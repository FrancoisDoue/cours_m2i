```bash
git init
echo > file.txt
git add .; git commit -m 'first commit'
echo > file2.txt
git add file2.txt
git commit -m 'second commit'
git log --oneline
echo "test" > file2.txt
git commit -am 'modification'
git reset --hard 061931e
git log --oneline
git checkout e9c76dd

git switch -c dev
    #git checkout -b dev

echo "modif" >> file.txt
git commit -am 'test-new-branch'
git branch
git tag v0.1.0

git switch main
    #git checkout main

git tag
git branch -D dev
git branch
```