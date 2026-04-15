#!/bin/bash
#
# Install Git Hooks for Code Quality Enforcement
# Run: bash scripts/install-git-hooks.sh
#

set -e

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

echo -e "${BLUE}========================================${NC}"
echo -e "${BLUE}  Installing Git Hooks${NC}"
echo -e "${BLUE}========================================${NC}"
echo ""

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"

cd "$PROJECT_ROOT"

# Create hooks directory
mkdir -p .git/hooks

# ============================
# pre-commit hook
# ============================
echo -e "${YELLOW}Installing pre-commit hook...${NC}"

cat > .git/hooks/pre-commit << 'HOOK'
#!/bin/bash
# Pre-commit hook: validates files and formats Java

set -e

echo "Running pre-commit checks..."

# 1. Check for spaces in filenames
echo "  Checking filenames..."
if git diff --cached --name-only | grep -q " "; then
    echo "ERROR: Files with spaces in name found. Use hyphens instead."
    exit 1
fi

# 2. Check for invalid special characters
echo "  Checking special characters..."
if git diff --cached --name-only | grep -E '[<>\\:"|?*]'; then
    echo "ERROR: Files with invalid special characters found."
    exit 1
fi

# 3. Format Java files
echo "  Formatting Java files..."
PROJECT_ROOT="$(git rev-parse --show-toplevel)"
FORMATTER_JAR="$PROJECT_ROOT/tools/google-java-format.jar"

if [ -f "$FORMATTER_JAR" ]; then
    # Get staged Java files
    STAGED_JAVA=$(git diff --cached --name-only --diff-filter=ACM | grep '\.java$' || true)
    if [ -n "$STAGED_JAVA" ]; then
        echo "$STAGED_JAVA" | while read -r file; do
            if [ -f "$file" ]; then
                java -jar "$FORMATTER_JAR" --replace "$file"
            fi
        done
        # Re-add formatted files
        echo "$STAGED_JAVA" | xargs git add
    fi
fi

echo "Pre-commit checks passed!"
exit 0
HOOK

chmod +x .git/hooks/pre-commit
echo -e "${GREEN}  ✓ pre-commit installed${NC}"

# ============================
# pre-push hook
# ============================
echo -e "${YELLOW}Installing pre-push hook...${NC}"

cat > .git/hooks/pre-push << 'HOOK'
#!/bin/bash
# Pre-push hook: runs compile check before pushing

set -e

echo "Running pre-push checks..."

# Get project root
PROJECT_ROOT="$(git rev-parse --show-toplevel)"

# Run Maven compile check
echo "  Running Maven compile..."
if ! (cd "$PROJECT_ROOT" && mvn -q -DskipTests compile); then
    echo "ERROR: Maven compile failed. Fix errors before pushing."
    exit 1
fi

echo "Pre-push checks passed!"
exit 0
HOOK

chmod +x .git/hooks/pre-push
echo -e "${GREEN}  ✓ pre-push installed${NC}"

# ============================
# commit-msg hook
# ============================
echo -e "${YELLOW}Installing commit-msg hook...${NC}"

cat > .git/hooks/commit-msg << 'HOOK'
#!/bin/bash
# Commit-msg hook: enforces conventional commits

COMMIT_MSG_FILE=$1
COMMIT_MSG=$(head -n1 "$COMMIT_MSG_FILE")

# Conventional commit pattern
PATTERN='^(feat|fix|docs|style|refactor|test|chore|ci|build|perf)(\([a-z-]+\))?: .+$'

if ! echo "$COMMIT_MSG" | grep -qE "$PATTERN"; then
    echo ""
    echo "ERROR: Commit message doesn't follow conventional commit format"
    echo ""
    echo "Expected format: <type>(<scope>): <message>"
    echo ""
    echo "Types:"
    echo "  feat     - New feature or functionality"
    echo "  fix      - Bug fix"
    echo "  docs     - Documentation changes only"
    echo "  style    - Code style changes (formatting, semicolons, etc.)"
    echo "  refactor - Code refactoring without changing behavior"
    echo "  test     - Adding or correcting tests"
    echo "  chore    - Maintenance tasks (build, deps, etc.)"
    echo "  ci       - CI/CD configuration changes"
    echo "  build    - Build system or dependency changes"
    echo "  perf     - Performance improvements"
    echo ""
    echo "Examples:"
    echo "  feat: add user authentication"
    echo "  fix(auth): resolve login bug"
    echo "  docs: update API documentation"
    echo ""
    exit 1
fi

exit 0
HOOK

chmod +x .git/hooks/commit-msg
echo -e "${GREEN}  ✓ commit-msg installed${NC}"

# ============================
# Summary
# ============================
echo ""
echo -e "${GREEN}========================================${NC}"
echo -e "${GREEN}  Git Hooks Installed!${NC}"
echo -e "${GREEN}========================================${NC}"
echo ""
echo "Hooks installed:"
echo "  • pre-commit - Validates files, formats Java"
echo "  • commit-msg - Enforces conventional commits"
echo "  • pre-push - Runs Maven compile check"
echo ""
echo "To bypass in emergencies:"
echo "  git commit --no-verify    (skip pre-commit, commit-msg)"
echo "  git push --no-verify      (skip pre-push)"
echo ""
