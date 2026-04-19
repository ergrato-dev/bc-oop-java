#!/bin/bash

################################################################################
# Auto-commit script for bc-oop-java
# Automatically commits changes with conventional commit messages
# Usage: Run via cron every 5 minutes
################################################################################

# Configuration
PROJECT_DIR="/home/epti/Documentos/epti-dev/bc-channel/bc-oop-java"
LOG_FILE="$PROJECT_DIR/.autocommit.log"
MAX_LOG_SIZE=10485760  # 10MB

# Change to project directory
cd "$PROJECT_DIR" || exit 1

# Rotate log if too large
if [ -f "$LOG_FILE" ] && [ $(stat -f%z "$LOG_FILE" 2>/dev/null || stat -c%s "$LOG_FILE" 2>/dev/null) -gt $MAX_LOG_SIZE ]; then
    mv "$LOG_FILE" "$LOG_FILE.old"
fi

# Function to log with timestamp
log() {
    echo "[$(date '+%Y-%m-%d %H:%M:%S')] $1" >> "$LOG_FILE"
}

log "=== Starting auto-commit check ==="

# Check if there are changes
if ! git diff --quiet || ! git diff --cached --quiet || [ -n "$(git ls-files --others --exclude-standard)" ]; then
    log "Changes detected, preparing commit..."
    
    # Add all changes
    git add -A
    
    # Detect the type of changes
    COMMIT_TYPE="chore"
    SCOPE=""
    WHAT=""
    FOR=""
    IMPACT=""
    
    # Check what changed
    if git diff --cached --name-only | grep -q "^bootcamp/semana-"; then
        WEEK=$(git diff --cached --name-only | grep "^bootcamp/semana-" | head -1 | sed 's|bootcamp/semana-\([0-9]*\)/.*|\1|')
        if [ -n "$WEEK" ]; then
            SCOPE="week-$WEEK"
            
            # Detect specific type of change
            if git diff --cached --name-only | grep -q "\.md$"; then
                COMMIT_TYPE="docs"
                WHAT="update documentation"
                FOR="week $WEEK content"
                IMPACT="improves learning materials"
            elif git diff --cached --name-only | grep -q "\.java$"; then
                COMMIT_TYPE="feat"
                WHAT="add exercises and examples"
                FOR="week $WEEK practical training"
                IMPACT="enhances student practice"
            elif git diff --cached --name-only | grep -q "\.svg$"; then
                COMMIT_TYPE="style"
                WHAT="add visual resources"
                FOR="week $WEEK illustrations"
                IMPACT="improves content clarity"
            elif git diff --cached --name-only | grep -q "\.json$\|\.yaml$"; then
                COMMIT_TYPE="feat"
                WHAT="add evaluation rubrics"
                FOR="week $WEEK assessment"
                IMPACT="enables student evaluation"
            fi
        fi
    elif git diff --cached --name-only | grep -q "^docs/"; then
        COMMIT_TYPE="docs"
        SCOPE="docs"
        WHAT="update project documentation"
        FOR="instructors and contributors"
        IMPACT="improves project understanding"
    elif git diff --cached --name-only | grep -q "\.py$"; then
        COMMIT_TYPE="feat"
        SCOPE="evaluation"
        WHAT="update evaluation system"
        FOR="automated grading"
        IMPACT="streamlines assessment process"
    elif git diff --cached --name-only | grep -q "README\|CONTRIBUTING\|CODE_OF_CONDUCT"; then
        COMMIT_TYPE="docs"
        WHAT="update project files"
        FOR="repository maintenance"
        IMPACT="improves project governance"
    else
        WHAT="update project files"
        FOR="general maintenance"
        IMPACT="keeps project current"
    fi
    
    # Build commit message with conventional commits format
    if [ -n "$SCOPE" ]; then
        COMMIT_MSG="$COMMIT_TYPE($SCOPE): $WHAT"
    else
        COMMIT_MSG="$COMMIT_TYPE: $WHAT"
    fi
    
    # Add extended description with what/for/impact
    COMMIT_MSG="$COMMIT_MSG

What? $WHAT
For? $FOR
Impact? $IMPACT

🤖 Auto-committed on $(date '+%Y-%m-%d at %H:%M:%S')"
    
    # Commit changes
    if git commit -m "$COMMIT_MSG"; then
        log "✅ Commit successful: $COMMIT_MSG"
        
        # Push to remote
        if git push origin main 2>&1 | tee -a "$LOG_FILE"; then
            log "✅ Push successful"
        else
            log "⚠️  Push failed, will retry on next run"
        fi
    else
        log "❌ Commit failed"
    fi
else
    log "No changes detected, skipping commit"
fi

log "=== Auto-commit check completed ==="
echo "" >> "$LOG_FILE"
