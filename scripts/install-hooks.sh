#!/bin/bash
#
# Install commit-msg Git Hook for Conventional Commits
# Run this script to set up conventional commit checking
#

set -e

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

echo -e "${BLUE}========================================${NC}"
echo -e "${BLUE}  Installing commit-msg Git Hook${NC}"
echo -e "${BLUE}========================================${NC}"
echo ""

# Get the directory where this script is located
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"

# Save original directory
ORIGINAL_DIR="$PWD"

# Search upward for .git directory
CURRENT_DIR="$PWD"
while [ "$CURRENT_DIR" != "/" ]; do
    if [ -d "$CURRENT_DIR/.git" ]; then
        PROJECT_ROOT="$CURRENT_DIR"
        break
    fi
    # Go up one level
    PARENT_DIR="$(dirname "$CURRENT_DIR")"
    if [ "$PARENT_DIR" = "$CURRENT_DIR" ]; then
        break
    fi
    CURRENT_DIR="$PARENT_DIR"
done

# Check if we found a git repo
if [ -z "$PROJECT_ROOT" ]; then
    echo -e "${RED}Error: Not a git repository${NC}"
    echo -e "${YELLOW}Please run this script from within a git repository${NC}"
    exit 1
fi

# Navigate to project root
cd "$PROJECT_ROOT"

echo -e "${BLUE}Project root: ${PROJECT_ROOT}${NC}"

# Create hooks directory if it doesn't exist
mkdir -p .git/hooks

# Install pre-commit hook for validation
echo -e "${YELLOW}Installing pre-commit hook...${NC}"

cat > .git/hooks/pre-commit << 'HOOK'
#!/bin/bash
# Pre-commit hook for validation

echo "Running pre-commit validation..."

# Check for files with spaces
if git diff --cached --name-only | grep " "; then
    echo "ERROR: Files with spaces found. Please use hyphens instead."
    exit 1
fi

# Check for special characters in filenames
if git diff --cached --name-only | grep -E '[<>\\:"|?*]'; then
    echo "ERROR: Files with special characters found."
    exit 1
fi

echo "Pre-commit validation passed!"
exit 0
HOOK

chmod +x .git/hooks/pre-commit
echo -e "${GREEN}# Pre-commit hook installed${NC}"

# Install commit-msg hook for conventional commits
echo -e "${YELLOW}Installing commit-msg hook...${NC}"

cat > .git/hooks/commit-msg << 'HOOK'
#!/bin/bash
#
# Commit-msg hook for conventional commits
#

COMMIT_MSG_FILE=$1
COMMIT_MSG=$(head -n1 "$COMMIT_MSG_FILE")

# Check conventional commit format
if ! echo "$COMMIT_MSG" | grep -qE '^(feat|fix|docs|style|refactor|test|chore|ci|build|perf)(\(.+\))?: .+'; then
    echo ""
    echo "⚠️  Warning: Commit message doesn't follow conventional commit format"
    echo ""
    echo "Expected format: <type>(<scope>): <description>"
    echo ""
    echo "Types: feat, fix, docs, style, refactor, test, chore, ci, build, perf"
    echo ""
    echo "Examples:"
    echo "  feat: add user authentication"
    echo "  fix(auth): resolve login bug"
    echo "  docs: update API documentation"
    echo ""
    # Don't block, just warn
fi

exit 0
HOOK

chmod +x .git/hooks/commit-msg
echo -e "${GREEN}✓ Commit-msg hook installed${NC}"

echo ""
echo -e "${GREEN}========================================${NC}"
echo -e "${GREEN}  Git Hook Installed!${NC}"
echo -e "${GREEN}========================================${NC}"
echo ""
echo "Hooks installed:"
echo "  # pre-commit - Validates file naming and structure"
echo "  # commit-msg - Checks conventional commit format"
echo ""
echo "These hooks will now:"
echo "  # Validate file naming before commit"
echo "  # Warn about non-conventional commit messages"
echo ""
echo "To bypass hook in emergencies (not recommended):"
echo "  git commit --no-verify"
echo ""

# Verify all hooks are executable and installed
echo -e "${BLUE}Verifying installation...${NC}"
hooks=("pre-commit" "commit-msg")
for hook in "${hooks[@]}"; do
    if [ -x ".git/hooks/$hook" ]; then
        echo -e "${GREEN}# $hook is installed and executable${NC}"
    else
        echo -e "${YELLOW}# $hook may not be executable${NC}"
    fi
done

echo ""
