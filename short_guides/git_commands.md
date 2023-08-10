
## Config
| command | Description                           |
|---------|---------------------------------------|
| git config         | global USER.NAME "Jonas Hellgren"<br/>global USER.EMAIL "jonas.hellgren@volvo.com |
|     git config list     | shows config settings |
|    git init      | creates local repo |

## InfoShow

| command | Description                                 |
|---------|---------------------------------------------|
|    git status      | shows status                                |
|  git log   | list commit history, git log -2             |
|  git log --oneline      | compact log history                         |
| git log --all --decorate --oneline --graph     | pretty loggraph   |                          |
| git show <hash>        | display the changes for single commit   |                                          |
|git diff         |lists file changes, unstages files (before add)                                             |
|         |                                             |
|         |                                             |
|         |                                             |
|         |                                             |
|         |                                             |
|         |                                             |
|         |                                             |
|         |                                             |
|         |                                             |
|         |                                             |


## AddAndCommit

| command                 | Description                                 |
|-------------------------|---------------------------------------------|
| git add .               | dd changes in current folder but not above<br/>         |
| git add FILE            |add file to staging area                                             |
| git commit -m <message> |create commit from files in staging area (updates repo)                                             |
| git commit --amend   |update latest commit                                             |
|                         |                                             |
| git reset FILE          | removes FILE (with path)) from staging area |
| git reset               | removes all files from staging area         |

## RemoteInteraction

| command                          | Description                                           |
|----------------------------------|-------------------------------------------------------|
| git clone <url> <where to clone> | cloning remote repo, <where to clone> can be . (here) |
| git remote -v                    | info about remote repo, for ex after cloning it       |
| git remote add origin <url>      | defines origin alias                                                      |
| git pull <repoalias> <branch>    |updates local repo from remote repo/branch                   |
| git push <repoalias> <branch>    | updates local repo from remote repo/branch   |


## Branches
| command | Description                  |
|---------|------------------------------|
|git branch | lists local branches, -a => also on remote repos |
|git branch <name>          |creates branch <name>                              |
|git checkout <name>         | sets branch <name> as actual, head points to this one |
|git push <repoalias> <branch> |updates remote repo according to local repo/branch |
| git branch -d <name>          |delete local branch <name>   |
|git push origin --delete <name>|delete branch <name> on remote repo origin |

## UndoMistakes
| command               | Description                                                                                  |
|-----------------------|----------------------------------------------------------------------------------------------|
|git reset --hard <hashofoldcommit>| restores file- "walk back in time", warning files updated, careful <=> removes local changes |
|git reset --soft <hashofoldcommit>| as hard but keeps local changes                                                     |
|git clean -df |   remove all untracked files                                                |
| git reflog   |can be used to restore commits "deleted" by git reset, max up to 30 days                                     |
|  git revert <hashofcommit> |creates new commits to revert changes of earlier commits, undo earlier commits                                                |
|git cherrypick <hashofcommit> | copies <hashofcommit> commit to present branch, handy if commited to wrong branch|


## Merging
| command        | Description                                 |
|----------------|---------------------------------------------|
| merge <branch> | merges branch <name> into current branch |
| git  branch --merged |  shows merged/identical branches  |
| git  branch -d <name> |  deletes branch |
|                |                                             |
|                |                                             |

### Stash 
* General description => Creates "commits" independent of branch. Handy when e.g. want to switch between branches without committing.
* git stash save "<message>" =>  saves working files in stash que
* git stash list => lists stashes
* git stash apply <iteminstashlist>  => update working files according specific stash
* git stash pop   => update according latest stash, that item disappears from stash list


## Rebase
* definition => moves feature branch so begins at the tip of the master branch. Rewrites history. Creates new commits for all original feature branch commits. *rules =>  don't change history when other peoples using same branch, never change history on master, only change history for commits not yet been paused * 
* git switch <branch-name> => identical to git checkout except flag for creating new branch is -c for switch and -b for checkout
 
## Squash 
* definition => Squash is about fusing multiple commits into one
* git rebase -i HEAD~4  => fuses 4 commits back
* git rebase -i :<commit-hash>  => fuses until <commit-hash>, opens text editor where {pick,squash} determines commit fusing
* git merge --squash <branch-name>  => Take all changes from <branch-name> and applies to current branch, needs commmit to take affect
}