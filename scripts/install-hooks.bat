@echo off
REM Install commit-msg Git Hook for Conventional Commits (Windows)
REM Run this script to set up conventional commit checking

echo ========================================
echo   Installing commit-msg Git Hook
echo ========================================
echo.

REM Save original directory
set "ORIGINAL_DIR=%CD%"

REM Search upward for .git directory
set "CURRENT_DIR=%CD%"
:search_loop
if exist "%CURRENT_DIR%\.git" (
    set "PROJECT_ROOT=%CURRENT_DIR%"
    goto found_git
)
REM Go up one level
for %%I in ("%CURRENT_DIR%\..") do set "PARENT_DIR=%%~fI"
if "%PARENT_DIR%"=="%CURRENT_DIR%" (
    REM Reached root without finding .git
    goto not_found
)
set "CURRENT_DIR=%PARENT_DIR%"
goto search_loop

:not_found
echo [ERROR] Not a git repository
echo [INFO] Please run this script from within a git repository
cd /d "%ORIGINAL_DIR%"
exit /b 1

:found_git
cd /d "%PROJECT_ROOT%"
echo [INFO] Project root: %CD%

REM Create hooks directory if it doesn't exist
if not exist ".git\hooks" mkdir .git\hooks

REM Install pre-commit hook
echo [1/4] Installing pre-commit hook...
> .git\hooks\pre-commit (
    echo @echo off
    echo REM Pre-commit hook for validation
    echo setlocal enabledelayedexpansion
    echo.
    echo echo Running pre-commit validation...
    echo.
    echo set SPACE_ERRORS=0
    echo set SPECIAL_ERRORS=0
    echo.
    echo REM Check for files with spaces in staged files
    echo for /f "delims=" %%%%f in ^('git diff --cached --name-only'^) do ^(
    echo     set "file=%%%%f"
    echo     set "check=!file!"
    echo     if not "!check: =!"=="!check!" ^(
    echo         echo [ERROR] File with spaces: !file!
    echo         set /a SPACE_ERRORS=+1
    echo     ^)
    echo ^)
    echo.
    echo REM Check for special characters in staged files
    echo for /f "delims=" %%%%f in ^('git diff --cached --name-only'^) do ^(
    echo     set "file=%%%%f"
    echo     set "check=!file!"
    echo     if not "!check:<=!"=="!check!" ^(
    echo         echo [ERROR] File with special chars: !file!
    echo         set /a SPECIAL_ERRORS=+1
    echo     ^) else if not "!check:>=!"=="!check!" ^(
    echo         echo [ERROR] File with special chars: !file!
    echo         set /a SPECIAL_ERRORS=+1
    echo     ^) else if not "!check:\"=!"=="!check!" (
    echo         echo [ERROR] File with special chars: !file!
    echo         set /a SPECIAL_ERRORS=+1
    echo     ^) else if not "!check:?=!"=="!check!" ^(
    echo         echo [ERROR] File with special chars: !file!
    echo         set /a SPECIAL_ERRORS=+1
    echo     ^) else if not "!check:*=!"=="!check!" ^(
    echo         echo [ERROR] File with special chars: !file!
    echo         set /a SPECIAL_ERRORS=+1
    echo     ^) else if not "!check:|=!"=="!check!" ^(
    echo         echo [ERROR] File with special chars: !file!
    echo         set /a SPECIAL_ERRORS=+1
    echo     ^) else if not "!check:"=!"=="!check!" (
    echo         echo [ERROR] File with special chars: !file!
    echo         set /a SPECIAL_ERRORS=+1
    echo     ^)
    echo ^)
    echo.
    echo set /a TOTAL=SPACE_ERRORS+SPECIAL_ERRORS
    echo if ^!TOTAL^! gtr 0 ^(
    echo     echo [FAILED] Found ^!TOTAL^! naming violations
    echo     exit /b 1
    echo ^)
    echo.
    echo echo [OK] Pre-commit validation passed!
    echo exit /b 0
)

echo [OK] Pre-commit hook installed

REM Install commit-msg hook
echo [2/2] Installing commit-msg hook...
> .git\hooks\commit-msg (
    echo @echo off
    echo REM Commit-msg hook for conventional commits
    echo setlocal EnableDelayedExpansion
    echo.
    echo set "MSG_FILE=%%~1"
    echo set /p MSG=^<"%%MSG_FILE%%"
    echo.
    echo echo %%MSG%% ^| findstr /R "^^\(feat^|fix^|docs^|style^|refactor^|test^|chore^|ci^|build^|perf\)\(\[^\)\]\*\)?: .*" ^>nul
    echo if errorlevel 1 ^(
    echo     echo.
    echo     echo [WARNING] Commit message doesn't follow conventional commit format
    echo     echo.
    echo     echo Expected format: ^<type^>^(^<scope^>^): ^<description^>
    echo     echo.
    echo     echo Types: feat, fix, docs, style, refactor, test, chore, ci, build, perf
    echo     echo.
    echo     echo Examples:
    echo     echo   feat: add user authentication
    echo     echo   fix^(auth^): resolve login bug
    echo     echo   docs: update API documentation
    echo     echo.
    echo     REM Don't block, just warn
    echo ^)
    echo.
    echo exit /b 0
)
echo [OK] Commit-msg hook installed

echo.
echo ========================================
echo   Git Hooks Installed!
echo ========================================
echo.
echo Hooks installed:
echo   - pre-commit - Validates file naming and structure
echo   - commit-msg - Checks conventional commit format
echo.
echo These hooks will now:
echo   [OK] Validate file naming before commit
echo   [OK] Warn about non-conventional commit messages
echo.
echo [INFO] Verifying installation...
if exist ".git\hooks\pre-commit" (
    echo [OK] pre-commit installed
) else (
    echo [WARNING] pre-commit not found
)
if exist ".git\hooks\commit-msg" (
    echo [OK] commit-msg installed
) else (
    echo [WARNING] commit-msg not found
)
echo.
echo To bypass hook in emergencies (not recommended):
echo   git commit --no-verify
echo.

pause
