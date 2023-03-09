
[vagrant@host1 ~]$ cd git
[vagrant@host1 git]$ pwd - 현재 작업 디렉토리를 표시
/home/vagrant/git
[vagrant@host1 git]$ cd - 디렉토리를 이동
/home/vagrant
[vagrant@host1 ~]$ cd git
[vagrant@host1 git]$ file 지정된 파일 확인

[vagrant@host1 git]$ file bltcamp-ncp
bltcamp-ncp: cannot open (No such file or directory)
[vagrant@host1 git]$ ls
3332.txt  333.txt  a.txt  bitcamp-ncp  bitcamp-study  bitcamp-test  default:  mkdir  mkidr  test.txt  vagrant  vagrnat
[vagrant@host1 git]$ file 3332.txt
3332.txt: ASCII text

[vagrant@host1 git]$ less
Missing filename ("less --help" for help)
[vagrant@host1 git]$ less (파일의 내용을 한 화면에 보여주는 명령어)
-bash: syntax error near unexpected token `파일의'

[vagrant@host1 git]$ cp - 파일,디렉토리를 복사
[vagrant@host1 git]$ cp 333.txt 3333.txt
[vagrant@host1 git]$ ls
3332.txt  333.txt  bitcamp-ncp    bitcamp-test  mkdir  test.txt  vagrnat
3333.txt  a.txt    bitcamp-study  default:      mkidr  vagrant

[vagrant@host1 git]$ mv - 파일이나 디렉토리를 이동
mv: target ‘이동’ is not a directory
[vagrant@host1 git]$ mv 3333.txt bitcamp-test
[vagrant@host1 git]$ ls
3332.txt  333.txt  a.txt  bitcamp-ncp  bitcamp-study  bitcamp-test  default:  mkdir  mkidr  test.txt  vagrant  vagrnat
[vagrant@host1 git]$ cd bitcamp-test
[vagrant@host1 bitcamp-test]$ ls
2.txt  3333.txt  jkyun.txt  jy.txt  README.md  shimwoojun.txt  wish.txt.txt
[vagrant@host1 bitcamp-test]$ cd ..

[vagrant@host1 git]$ mkdir - 새로운 디렉토리 생성
[vagrant@host1 git]$ ls
-     새로운    3332.txt  a.txt        bitcamp-study  default:  mkidr     vagrant
생성  디렉토리  333.txt   bitcamp-ncp  bitcamp-test   mkdir     test.txt  vagrnat

[vagrant@host1 git]$ rm - 파일 디렉토리 삭제
rm: cannot remove ‘-’: Is a directory
rm: cannot remove ‘파일’: No such file or directory
rm: cannot remove ‘디렉토리’: Is a directory
rm: cannot remove ‘삭제’: No such file or directory
[vagrant@host1 git]$ rm - 새로운 디렉토리 생성
rm: cannot remove ‘-’: Is a directory
rm: cannot remove ‘새로운’: Is a directory
rm: cannot remove ‘디렉토리’: Is a directory
rm: cannot remove ‘생성’: Is a directory
[vagrant@host1 git]$ ls
-     새로운    3332.txt  a.txt        bitcamp-study  default:  mkidr     vagrant
생성  디렉토리  333.txt   bitcamp-ncp  bitcamp-test   mkdir     test.txt  vagrnat

[vagrant@host1 git]$ rm 3332.txt
[vagrant@host1 git]$ rm -r 새로운 디렉토리 생성
[vagrant@host1 git]$ ls
-  333.txt  a.txt  bitcamp-ncp  bitcamp-study  bitcamp-test  default:  mkdir  mkidr  test.txt  vagrant  vagrnat
[
vagrant@host1 git]$ ln
ln: missing file operand
Try 'ln --help' for more information.
[vagrant@host1 git]$ ln 링크파일을 만들때 사용
ln: target ‘사용’ is not a directory
[vagrant@host1 git]$ ln -s [OPTIONS] FILE LINK
ln: target ‘LINK’ is not a directory
-bash: -: command not found

[vagrant@host1 git]$ type은 지정된 명령어가 쉘에 내장된 명령어인지, 외부명령어인지, 앨리어스 명령어인지 등을 확인하는 명령어이다.
-bash: type은: command not found
[vagrant@host1 git]$ type test
test is a shell builtin
[vagrant@host1 git]$ type cp
cp is hashed (/usr/bin/cp)
[vagrant@host1 git]$ tupe find
-bash: tupe: command not found

[vagrant@host1 git]$ which - 특정명령의 위치를 찾아주는 명령어이다.
[vagrant@host1 git]$ which -a find
/usr/bin/find

[vagrant@host1 git]$ man - 명령어 프로그램 사용법을 확인할때 사용
[vagrant@host1 git]$ man rm

[vagrant@host1 git]$ apropos 검색어와 관련있는 명령어를 설명과 함께 출혁한다

[vagrant@host1 git]$ git/bitcamp-test/apropos
-bash: git/bitcamp-test/apropos: No such file or directory

[vagrant@host1 git]$ info - 명령어의 사용방법.옵션 등을 나타냄

[1]+  Stopped                 info - 명령어의 사용방법.옵션 등을 나타냄
[vagrant@host1 git]$ whatis - 명령에 대한 간단한 설명을 출력한다.
[vagrant@host1 git]$ whatis ls
ls (1)               - list directory contents
ls (1p)              - list directory contents

[vagrant@host1 git]$ alias 별칭이라는 뜻으로 길이가 긴 명령어를 간단한 이름으로 바꿔서 등록 가능하다
[vagrant@host1 git]$ alias flog='cd /log/myservice/info'
[vagrant@host1 git]$ unalias flog
[vagrant@host1 git]$