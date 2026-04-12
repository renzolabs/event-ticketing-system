#!/bin/bash
#
# Format all Java files using google-java-format CLI
# Auto-fixes formatting issues
#

set -e

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"
FORMATTER_JAR="$PROJECT_ROOT/tools/google-java-format.jar"

echo -e "${BLUE}========================================${NC}"
echo -e "${BLUE}  Java Code Formatter${NC}"
echo -e "${BLUE}========================================${NC}"
echo ""

# Check if formatter jar exists
if [ ! -f "$FORMATTER_JAR" ]; then
    echo -e "${YELLOW}Downloading google-java-format...${NC}"
    mkdir -p "$PROJECT_ROOT/tools"
    curl -L -o "$FORMATTER_JAR" \
        "https://github.com/google/google-java-format/releases/download/v1.22.0/google-java-format-1.22.0-all-deps.jar"
    echo -e "${GREEN}✓ Downloaded google-java-format${NC}"
fi

# Find all Java files tracked by git
cd "$PROJECT_ROOT"
JAVA_FILES=$(git ls-files "*.java" 2>/dev/null || find . -name "*.java" -not -path "*/target/*" -not -path "*/.git/*")

if [ -z "$JAVA_FILES" ]; then
    echo -e "${YELLOW}No Java files found${NC}"
    exit 0
fi

FILE_COUNT=$(echo "$JAVA_FILES" | wc -l)
echo -e "${BLUE}Found ${FILE_COUNT} Java files${NC}"
echo ""

# Format files
echo -e "${YELLOW}Formatting Java files...${NC}"
echo "$JAVA_FILES" | xargs -I {} java -jar "$FORMATTER_JAR" --replace {}

echo ""
echo -e "${GREEN}========================================${NC}"
echo -e "${GREEN}  Formatting Complete${NC}"
echo -e "${GREEN}========================================${NC}"
