# 命令行相关

### 1. ipconfig 详解

>  使用 ipconfig 查看ip地址

使用场景：Windows 系统

功能：用于显示计算机的网络配置信息。

案例：

```cmd
Ethernet adapter Local Area Connection:					// 以太网适配器

   Connection-specific DNS Suffix . :
   IPv4 Address. . . . . . . . . . . : 192.168.1.100	// ipv4地址
   Subnet Mask . . . . . . . . . . . : 255.255.255.0	// 子网掩码
   Default Gateway . . . . . . . . . : 192.168.1.1		// 默认网关地址

Wireless LAN adapter Wi-Fi:								// 无线局域网适配器

   Connection-specific DNS Suffix . :
   IPv4 Address. . . . . . . . . . . : 192.168.0.150
   Subnet Mask . . . . . . . . . . . : 255.255.255.0
   Default Gateway . . . . . . . . . : 192.168.0.1

   IPv6 Address. . . . . . . . . . . : 2001:0db8:85a3:0000:0000:8a2e:0370:7334
   Default Gateway . . . . . . . . . : fe80::1%1
```

常见字段及含义

| 英文                                          | 中文             | 含义                                                         |
| --------------------------------------------- | ---------------- | ------------------------------------------------------------ |
| Wireless LAN adapter                          | 无线局域网适配器 | 用于连接到无线局域网（Wi-Fi）的网络接口。                    |
| Ethernet adapter                              | 以太网适配器     | 用于连接到有线局域网（Ethernet）的网络接口。                 |
| Wireless LAN adapter Local Area Connection* 1 |                  | 表示计算机上的第一个无线局域网适配器连接到了本地区域连接     |
| Ethernet adapter Bluetooth Network Connection |                  | 表示计算机上的蓝牙适配器连接到了网络                         |
| Ethernet adapter vEthernet (Default Switch)   |                  | 表示计算机上的虚拟以太网适配器连接到了名为"Default Switch"的虚拟交换机 |

