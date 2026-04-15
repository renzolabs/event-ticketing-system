# 🤖 AI Behavior Rules

## 🚨 Mandatory Startup Protocol

**CRITICAL: AI MUST complete this sequence BEFORE any work.**

### Step 1: Load Configuration (30 seconds)
```
Load: .windsurf/config.json
Load: config/global/naming-conventions.md
Load: config/global/ai-behavior-rules.md  
Load: config/global/folder-structure.md
```

### Step 2: Identify Project Context (30 seconds)
```
Detect: Project type (spring-boot, react, python, etc.)
Detect: Language (java, python, javascript, etc.)
Load: config/languages/{language}.yaml
Load: config/project-types/{type}.yaml
```

### Step 3: Validate Understanding (30 seconds)
```
Run: scripts/validate-governance.sh (or .bat)
Verify: Can explain naming conventions
Verify: Can explain folder structure
Verify: Knows where to put different file types
```

### Step 4: Self-Test (30 seconds)
```
Answer:
1. What case for documentation files? → kebab-case
2. What case for Java classes? → PascalCase
3. Where do epics go? → docs/plannings/epics/
4. What folder for AI rules? → docs/governance/
```

**Total Time: 2 minutes before writing ANY code**

---

## 📁 File Creation Rules (Auto-Enforced)

### Rule 1: Naming Validation (MANDATORY)

**Before creating ANY file:**

1. **Identify file type**
   - Documentation (.md) → kebab-case
   - Java (.java) → PascalCase (classes), camelCase (methods)
   - Python (.py) → snake_case
   - JavaScript (.js/.jsx) → PascalCase (components), camelCase (utils)
   - Scripts (.sh/.bat) → kebab-case

2. **Validate against pattern**
   ```
   If documentation:
     Must match: ^[a-z0-9]+(-[a-z0-9]+)*\.md$
     Examples: epic-user-auth.md ✓, MyFile.md ✗
   
   If Java class:
     Must match: ^[A-Z][a-zA-Z0-9]*\.java$
     Examples: UserController.java ✓, userController.java ✗
   ```

3. **Check for violations**
   - ❌ Spaces in name
   - ❌ Special characters
   - ❌ Mixed case in docs
   - ❌ Vague names (final, new, test)

4. **Auto-action on violation**
   - STOP file creation
   - Suggest compliant name
   - Explain rule being broken

### Rule 2: Folder Location Validation

**Before creating ANY file:**

1. **Identify correct folder**
   ```
   Documentation:
   - AI rules → docs/governance/
   - Templates → docs/templates/
   - API docs → docs/api/
   - Dev guides → docs/development/[java|frontend|general|ai]/
   
   Code:
   - Controllers → src/.../api/
   - Services → src/.../application/
   - Entities → src/.../domain/
   - Repositories → src/.../infrastructure/
   ```

2. **Validate folder exists**
   - If missing, suggest creating it
   - Use kebab-case for new folders

3. **Auto-action on wrong location**
   - Suggest correct folder
   - Explain folder purpose
   - Move or reject

### Rule 3: Template Usage

**When creating standard documents:**

| Document Type | Required Template | Location |
|---------------|-------------------|----------|
| Epic | epic-template.md | docs/templates/epics/ |
| Story | story-template.md | docs/templates/stories/ |
| PR | pull-request-template.md | templates/pr/ |

**Auto-action:**
- Load template content
- Fill in placeholders
- Ensure all sections present

### Rule 4: Code Standards

**When generating code:**

**Java:**
- Use 4-layer architecture (api→application→domain→infrastructure)
- PascalCase classes
- camelCase methods
- `final` keyword for parameters
- No wildcard imports
- Lombok for boilerplate

**Python:**
- snake_case functions
- PascalCase classes
- Type hints recommended
- Docstrings for public APIs

**JavaScript:**
- camelCase variables/functions
- PascalCase components
- async/await for async code
- Destructuring preferred

---

## 🚫 Prohibited Actions (NEVER Do These)

### File Operations
1. **NEVER** create files with spaces in names
2. **NEVER** use uppercase in documentation files
3. **NEVER** mix underscores and hyphens in same project
4. **NEVER** create vague names like `final`, `new`, `test`
5. **NEVER** put files in wrong folders
6. **NEVER** skip templates for standard documents

### Code Operations
1. **NEVER** skip validation before file creation
2. **NEVER** ignore naming convention warnings
3. **NEVER** create duplicate files
4. **NEVER** modify structure without permission
5. **NEVER** invent new conventions

### Documentation Operations
1. **NEVER** create docs without reading mandatory files first
2. **NEVER** skip pre-work checklist
3. **NEVER** use non-kebab-case for markdown
4. **NEVER** place governance files outside docs/governance/

---

## ✅ Pre-Work Checklist (MANDATORY)

Before creating ANY file, AI MUST verify:

```markdown
- [ ] Read ai-behavior-rules.md (this file)
- [ ] Read naming-conventions.md
- [ ] Read folder-structure.md
- [ ] Located correct folder for new file
- [ ] Confirmed correct naming format
- [ ] Have correct template ready (if applicable)
- [ ] Understand where to place code files
- [ ] Can explain naming choice if asked
```

**If ANY checkbox not ticked → STOP and complete first**

---

## 🔍 Auto-Validation Triggers

### Trigger: Before File Create
```yaml
actions:
  - validate_naming_against_convention
  - check_folder_location
  - check_template_exists
  - check_duplicates
  - log_validation_result
```

### Trigger: Before Code Generate
```yaml
actions:
  - validate_module_structure
  - check_layer_placement
  - verify_naming_convention
  - check_import_patterns
```

### Trigger: Before Doc Create
```yaml
actions:
  - validate_doc_naming
  - check_template_exists
  - verify_folder_location
  - check_governance_reference
```

---

## 🎯 Response Format Requirements

### When Creating Files

**MUST include:**
1. Naming convention check result
2. Folder location justification
3. Template usage (if applicable)
4. Compliance confirmation

**Example:**
```
Creating file: epic-user-authentication.md
✓ Naming: kebab-case (compliant)
✓ Location: docs/plannings/epics/ (correct)
✓ Template: epic-template.md (used)
✓ All validations passed
```

### When Suggesting Names

**MUST provide:**
1. Compliant name suggestion
2. Explanation of changes
3. Reference to rule applied

**Example:**
```
Suggested: user-profile-controller.md
Changes made:
  - Lowercased: UserProfile → user-profile
  - Added hyphens: userprofile → user-profile
Rule: Documentation uses kebab-case (naming-conventions.md section 1)
```

---

## 🧠 Memory Requirements

### Auto-Save Rules

AI MUST automatically save to memory:

```yaml
auto_save_triggers:
  - governance_update_detected
  - naming_violation_blocked
  - structure_change_made
  - important_decision_reached
  
memory_categories:
  - project_structure
  - naming_conventions
  - governance_version
  - ai_guidelines_hash
  - validation_results
```

### Cross-Machine Sync

```yaml
sync_targets:
  - local_memory
  - shared_git_repo
  - other_developer_machines
  
sync_triggers:
  - on_governance_change
  - on_validation_complete
  - on_file_structure_update
```

---

## 🎓 AI Self-Test

Before claiming ready, AI must answer correctly:

**Q1: What naming format for documentation files?**
→ kebab-case: type-description.md

**Q2: Where do epics go?**
→ docs/plannings/epics/

**Q3: What is the folder for AI guidelines?**
→ docs/governance/

**Q4: What is Java class naming convention?**
→ PascalCase

**Q5: What must be done before creating any file?**
→ Run pre-work checklist, validate naming, check location

**Q6: What happens on naming violation?**
→ Stop creation, suggest compliant name

**Score:** 6/6 = Ready to work

---

## 🔄 Continuous Compliance

### On Every File Operation

1. **Validate** naming before creation
2. **Check** folder location
3. **Use** templates when available
4. **Log** all operations
5. **Report** violations immediately

### On Governance Update

1. **Reload** configuration
2. **Revalidate** all cached rules
3. **Notify** if behavior changes
4. **Sync** across machines

---

## 🆘 Violation Escalation

### First Violation
- Warning message
- Education about rule
- Suggested fix

### Second Violation
- Required re-reading of guidelines
- Mandatory 2-minute review
- Confirm understanding

### Third Violation
- Blocked from creating files
- Requires human review
- Manual override needed

---

## 📚 Reference Documents

Always available for AI:
- `config/global/naming-conventions.md` - Complete naming guide
- `config/global/folder-structure.md` - Directory standards
- `config/languages/{language}.yaml` - Language specifics
- `config/project-types/{type}.yaml` - Framework specifics

---

**Version**: 1.0  
**Enforced**: Automatically by AI configuration  
**Applies To**: All AI agents (Cascade, Windsurf, etc.)  
**Last Updated**: April 2026
