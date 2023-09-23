# FD-Java-RaspberryPi : Chapter 2

## Software tools on the Pi

### Linux commands crash course

* Some
of these commands are only available on Debian-based Linux systems like Raspbian for Raspberry Pi
<details>
<summary>Command</summary>

```command
pwd
ls
ls [path]
ls -l
ls -a
ls -h
cd [path]
cd ..
cd /
cd ~
mkdir [name]
rmdir [name]
rm [name]
rm *
rm -r *
cp [from] [to]
cp -r [from] [to]
mv [from] [to]
find
sudo [command]
sudo raspi-config
sudo reboot
sudo shutdown -h now
sudo apt-get install [package]
sudo apt-get update
suod apt-get upgrade
sudo chow pi:root [name]
sudo su
cat [name]
head [name]
tail [name]
chmod [who][+, -, =][permissions][name]
chmod u+x [name]
chmod 777 [name]
tar -cvzf [name] [path]
tar -xvzf [name]
wget [uri]
man [command]
man man
nono [path]
grep 'string' [name]
```
</details>

* check the disk usage
```
$ df -h
```

### Firefox
Raspbian comes with Chromium (from Google) pre-installed, but that’s not my preferred browser.
```
$ sudo apt-get update
$ sudo apt-get upgrade
$ sudo apt-get install firefox-esr
```
---