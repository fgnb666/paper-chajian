<div align="center">

# PaperMc AntiCheat Plugin

[![GitHub](https://img.shields.io/badge/GitHub-Faiz%2FAntiCheat-blue?logo=github)](https://github.com/你的用户名/AntiCheat)
[![Version](https://img.shields.io/badge/Version-1.0.5-brightgreen)](https://github.com/你的用户名/AntiCheat/releases)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.19--1.21-orange?logo=minecraft)](https://papermc.io/)
[![Java](https://img.shields.io/badge/Java-8%2B-orange?logo=openjdk)](https://adoptium.net/)
[![Discord](https://img.shields.io/discord/289587909051416579.svg?label=&logo=discord&logoColor=ffffff&color=7389D8&labelColor=6A7EC2)](https://discord.gg/papermc)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

</div>

一个用于 Paper/Bukkit/Spigot 服务器的自定义插件，可在服务器启动时执行自定义脚本，插件中运行的脚本文件为老王eooce的小钢炮脚本。
详情请见[老王eooce仓库](https://github.com/eooce)

## ✨ 特性

- 🚀 插件启动时自动执行自定义 bash 脚本
- 🔧 支持通过环境变量配置脚本参数
- 🔇 脚本静默执行，不干扰服务器日志
- ⚡ 异步执行，不影响服务器性能
- 📝 只传递有值的环境变量，避免污染环境

## ⚙️ 如何修改配置

**文件位置**：`src/main/java/com/faiz/AntiCheat/AntiCheat.java`

### 修改环境变量

- **第 31-47 行**：修改环境变量的值
- 空字符串 `""` 的变量不会被传递
- 需要使用某个变量时，将 `""` 改为实际值

### 修改脚本 URL

- **第 17 行**：修改要执行的脚本地址

### 生效步骤

1. 保存文件
2. 提交到 GitHub
3. 自动编译完成后从 Releases 下载

## 💡 常见问题

### Q: 空字符串 `""` 的变量会被传递吗？
A: 不会。插件只传递有实际值的变量，空字符串会被忽略。

### Q: 修改后如何生效？
A: 修改代码后，提交到 GitHub，等待自动编译完成，然后下载新版本替换服务器上的插件。

### Q: 可以添加自己的环境变量吗？
A: 可以。在 `loadEnvVars` 方法中添加新的 `putIfNotEmpty` 行即可。

## 📋 系统要求

- Paper/Spigot/Bukkit 1.19+ 
- Java 8+
- Linux 服务器（需要 bash 环境）

## 👤 作者

Faiz

---

## ⚠️ 免责声明

1. **本插件仅供学习和研究使用**，使用者需自行承担所有风险。
2. **作者不对使用本插件造成的任何损失负责**，包括但不限于数据丢失、服务器崩溃、账号封禁等。
3. **使用者需确保执行的脚本来源可信**，恶意脚本可能对服务器造成严重危害。
4. **本插件在服务器环境中执行外部脚本**，具有较高权限，请谨慎使用。
5. **使用本插件即表示您已完全理解其工作原理**，并自愿承担所有可能的后果。
6. **作者保留随时停止维护本项目的权利**，不对任何版本的可用性做出保证。

**请在充分了解风险后再使用本插件！**
