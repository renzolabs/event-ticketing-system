# 🌿 Git Workflow Guide

This project uses a **clean, linear git history** without merge commits.

---

## 📋 Branch Strategy

| Branch | Purpose | Protection |
|--------|---------|------------|
| `main` | Production releases | Require PR + reviews |
| `develop` | Integration branch | Require PR |
| `feat/*` | Feature development | None |
| `fix/*` | Bug fixes | None |

---

## 🚀 Complete Development Workflow

### 1. Start New Feature

```bash
# Always branch from develop
git checkout develop
git pull origin develop
git checkout -b feat/your-feature-name
```

### 2. Develop & Commit

```bash
# Make changes, then commit with conventional format
git add .
git commit -m "feat: add user authentication"
```

**Commit types:** `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore`, `ci`, `build`

### 3. Keep Clean History (Before Merge)

If `develop` has moved ahead while you worked:

```bash
# Rebase your branch onto latest develop
git checkout develop
git pull origin develop
git checkout feat/your-feature-name
git rebase develop
# Fix any conflicts, then: git rebase --continue
```

### 4. Push & Open PR in GitHub

```bash
git push -u origin feat/your-feature-name
```

**Then open PR in GitHub:**
1. Go to https://github.com/renzolabs/event-ticketing-system
2. Click **"Pull requests"** → **"New pull request"**
3. Select:
   - **base:** `develop`
   - **compare:** `feat/your-feature-name`
4. Fill in PR title (same as main commit message)
5. Add description of changes
6. Click **"Create pull request"**
7. Request review from team members

### 5. Merge Process (PM/Lead Review)

**PM/Team Lead will:**
1. Review the PR in GitHub
2. Check for conflicts or issues
3. **If conflicts exist:** Notify developer to rebase and resolve
4. **If clean:** Approve and merge via GitHub UI
5. Delete the feature branch after merge

**Developer responsibilities:**
- Fix any merge conflicts when notified by PM
- Ensure CI checks pass before requesting review

#### Handling Conflicts (When PM notifies)

```bash
# On your feature branch
git checkout feat/your-feature-name

# Fetch latest develop
git fetch origin develop

# Rebase onto latest develop
git rebase origin/develop

# Resolve conflicts in files, then:
git add .
git rebase --continue

# Force push to update PR
git push --force-with-lease origin feat/your-feature-name
```

GitHub will automatically re-check the PR after push.

### 6. Cleanup After Merge

Once PR is merged (via GitHub):

```bash
# Update your local develop
git checkout develop
git pull origin develop

# Delete local feature branch
git branch -d feat/your-feature-name
```

---

## ⚡ Quick Reference

```bash
# Start feature
git checkout -b feat/new-feature develop

# Work & commit
git add .
git commit -m "feat: your changes"

# Push & create PR
git push -u origin feat/new-feature
# → Open PR in GitHub, request review

# After PM merges via GitHub - cleanup locally
git checkout develop
git pull origin develop
git branch -d feat/new-feature
```

---

## 🔑 Key Rules

| Rule | Why |
|------|-----|
| `--ff-only` | Prevents merge commits, keeps linear history |
| Branch from `develop` | Main is for releases only |
| Rebase before merge | Clean linear history |
| Conventional commits | Consistent changelog |
| PR required | Code review before merge |

---

## 📊 Visual Flow

```
main:    A---B---C---D (releases)
                ↑
develop:     B---C---D---E---F (integration)
                  ↑       ↑
feature:         C---E1---E2 (your work)
                    (rebase)
                 E1---E2 (clean)
```

---

## 🛠️ GitHub Settings (For Maintainers)

### Branch Protection Rules

Go to **Settings → Branches** → **Add rule**

**For `main` and `develop`:**
- ☑️ Require a pull request before merging
- ☑️ Require approvals (1 for develop, 2 for main)
- ☑️ Require status checks to pass (if CI enabled)
- ☑️ Require branches to be up to date before merging
- ☑️ Allow force pushes (for admins only)

---

## ❓ FAQ

**Q: What if rebase has conflicts?**  
A: Fix conflicts in files, `git add .`, `git rebase --continue`

**Q: Can I skip PR and push directly?**  
A: No. PR is required for code review.

**Q: What if `--ff-only` fails?**  
A: Your branch is not rebased. Do: `git rebase develop` first.

**Q: How to see clean history?**  
A: `git log --oneline --graph`
