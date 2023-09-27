# FD-Java-RaspberryPi : Chapter 1

## DHCP Configuration

* Raspberry Pi’s currently assigned IP address
```
$ hostname -I
```

* Your router’s gateway IP address
```
$ ip r | grep default
```

* Your router’s DNS (Domain Name System) IP address
```
sudo nano /etc/resolv.conf
```

## Add Static IP Settings
```
$ sudo nano /etc/dhcpcd.conf
```

```conf
interface NETWORK 
static ip_address=STATIC_IP/24
static routers=ROUTER_IP 
static domain_name_servers=DNS_IP
```

Replace the emboldened names as follows:
* NETWORK – your network connection type: eth0 (Ethernet) or wlan0 (wireless).
* STATIC_IP – the static IP address you want to set for the Raspberry Pi.
* ROUTER_IP – the gateway IP address for your router on the local network.
* DNS_IP – the DNS IP address (typically the same as your router’s gateway address).

<b>Reboot the Raspberry Pi</b>
```
$ sudo reboot

$ hostname -I
```

## SSH to Raspberry Pi

```
$ sudo raspi-config
```

Then navigate to <b>Interfacing Options > SSH</b> and select <b><Yes></b> at the prompt, "Would you like the SSH server to be enabled?" Press <b>Enter</b> to confirm, then select <b>Finish</b> to exit raspi-config. You’ll now be able to SSH into Pi from another computer.

## Configure Ubuntu RDP Connection

*  Install xrdp
```
$ sudo apt install xrdp

$ sudo systemctl enable xrdp
```

```
$ sudo adduser USERNAME
```
Replace "USERNAME" with the name you want to use for your user

## How to Use Sudo and the Sudoers File

<p>
Let’s look at some of the formats and rules to follow when editing sudoers:</br>
<div>
<tab>All lines starting with # are comments </br>
<tab><b>root ALL=(ALL:ALL) ALL</b> – this line means that the root user has unlimited privileges and can run any command on the system </br>
<tab><b> %admin ALL=(ALL) ALL</b> – the % sign specifies a group. Anyone in the admin group has the same privileges as of root user </br>
<tab> <b>%sudo   ALL=(ALL:ALL) ALL</b> – all users in the sudo group have the privileges to run any command
</div>
Another line of interest is #includedir /etc/sudoers.d, this means we can add configurations to the file sudoers.d and link it here.
</p>

```
$ sudo nano /etc/sudoers
```

```
USERNAME ALL=(ALL:ALL)  ALL
```
Replace "USERNAME" with the name you want to use for your user

---