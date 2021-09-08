package fodastico.user.Commands;

import fodastico.user.Apis.APIs;
import fodastico.user.FullVIP.VipallAPI;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Tag implements CommandExecutor
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (!(Sender instanceof Player)) {
            Sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return false;
        }
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("tag")) {
            if (Args.length == 0) {
                if (p.hasPermission("*")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §4§lDONO§f, §3§lDEV§f, §c§lGERENTE§f, §c§lADMIN§f, §5§lMOD+§f, §5§lMODGC§f, §5§lMOD§f, §5§lTRIAL§f, §3§lYOUTUBER+§f, §2§lBUILDER§f, §9§lAJUDANTE§f, §b§lYOUTUBER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.dev")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §3§lDEV§f, §c§lGERENTE§f, §c§lADMIN§f, §5§lMOD+§f, §5§lMODGC§f, §5§lMOD§f, §5§lTRIAL§f, §3§lYOUTUBER+§f, §2§lBUILDER§f, §9§lAJUDANTE§f, §b§lYOUTUBER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.gerente")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §c§lGERENTE§f, §c§lADMIN§f, §5§lMOD+§f, §5§lMODGC§f, §5§lMOD§f, §5§lTRIAL§f, §3§lYOUTUBER+§f, §2§lBUILDER§f, §9§lAJUDANTE§f, §b§lYOUTUBER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.admin")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §c§lADMIN§f, §5§lMOD+§f, §5§lMODGC§f, §5§lMOD§f, §5§lTRIAL§f, §3§lYOUTUBER+§f, §2§lBUILDER§f, §9§lAJUDANTE§f, §b§lYOUTUBER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.mod+")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §5§lMOD+§f, §5§lMODGC§f, §5§lMOD§f, §5§lTRIAL§f, §3§lYOUTUBER+§f, §2§lBUILDER§f, §9§lAJUDANTE§f, §b§lYOUTUBER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.modgc")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §5§lMODGC§f, §5§lMOD§f, §5§lTRIAL§f, §3§lYOUTUBER+§f, §2§lBUILDER§f, §9§lAJUDANTE§f, §b§lYOUTUBER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.mod")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §5§lMOD§f, §5§lTRIAL§f, §3§lYOUTUBER+§f, §2§lBUILDER§f, §9§lAJUDANTE§f, §b§lYOUTUBER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.trial")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §5§lTRIAL§f, §3§lYOUTUBER+§f, §2§lBUILDER§f, §9§lAJUDANTE§f, §b§lYOUTUBER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.ajudante")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §9§lAJUDANTE§f, §b§lYOUTUBER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.builder")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §2§lBUILDER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.ultimate") || VipallAPI.vipall) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.beta")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.premium")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.light")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.youtuber+")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §3§lYOUTUBER+§f, §9§lAJUDANTE§f, §b§lYOUTUBER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                if (p.hasPermission("rank.youtuber")) {
                    p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §b§lYOUTUBER§f, §d§lULTIMATE§f, §1§lBETA§f, §6§lPREMIUM§f, §a§lLIGHT§f, §7§lMEMBRO");
                    return true;
                }
                p.sendMessage("§9§lTAGS ATUAIS §fSuas tags: §7§lMEMBRO");
                return true;
            }
            else {
                if (Args[0].equalsIgnoreCase("dono")) {
                    if (p.hasPermission("*")) {
                        APIs.Dono(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §4§lDONO");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("dev")) {
                    if (p.hasPermission("tag.dev")) {
                        APIs.Dev(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §3§lDEV");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("gerente")) {
                    if (p.hasPermission("tag.gerente")) {
                        APIs.Gerente(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §c§lGERENTE");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("admin")) {
                    if (p.hasPermission("tag.admin")) {
                        APIs.Admin(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §c§lADMIN");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("mod+") || Args[0].equalsIgnoreCase("modplus")) {
                    if (p.hasPermission("tag.mod+")) {
                        APIs.ModPlus(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §5§lMOD+");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("modgc") || Args[0].equalsIgnoreCase("gcdetector")) {
                    if (p.hasPermission("tag.modgc")) {
                        APIs.ModGc(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §5§lMODGC");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("mod")) {
                    if (p.hasPermission("tag.mod")) {
                        APIs.Mod(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §5§lMOD");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("trial")) {
                    if (p.hasPermission("tag.trial")) {
                        APIs.Trial(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §5§lTRIAL");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("builder")) {
                    if (p.hasPermission("tag.builder")) {
                        APIs.Builder(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §2§lBUILDER");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("ajudante") || Args[0].equalsIgnoreCase("helper")) {
                    if (p.hasPermission("tag.ajudante")) {
                        APIs.Ajudante(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §9§lAJUDANTE");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("ultimate")) {
                    if (p.hasPermission("tag.ultimate") || VipallAPI.vipall) {
                        APIs.Ultimate(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §d§lULTIMATE");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("beta")) {
                    if (p.hasPermission("tag.beta") || VipallAPI.vipall) {
                        APIs.Beta(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §1§lBETA");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("premium")) {
                    if (p.hasPermission("tag.premium") || VipallAPI.vipall) {
                        APIs.Premium(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §6§lPREMIUM");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("light")) {
                    if (p.hasPermission("tag.light") || VipallAPI.vipall) {
                        APIs.Light(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §a§lLIGHT");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("youtuber") || Args[0].equalsIgnoreCase("yt")) {
                    if (p.hasPermission("tag.youtuber")) {
                        APIs.Youtuber(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §b§lYOUTUBER");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("youtuber+") || Args[0].equalsIgnoreCase("yt+")) {
                    if (p.hasPermission("tag.youtuber+")) {
                        APIs.YoutuberPlus(p);
                    }
                    else {
                        p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea n\u00e3o possui a tag §3§lYOUTUBER+");
                    }
                    return true;
                }
                if (Args[0].equalsIgnoreCase("normal") || Args[0].equalsIgnoreCase("membro")) {
                    APIs.Normal(p);
                    return true;
                }
                p.sendMessage("§9§lTAGS ATUAIS §fTag n\u00e3o existente.");
            }
        }
        return true;
    }
}
