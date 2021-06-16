package com.github.yannicklamprecht.spigot.tooling.example.spigottoolingexample;

import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.network.protocol.game.ClientboundAddMobPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;

public final class SpigotToolingExample extends JavaPlugin implements Listener {

  @Override
  public void onEnable() {
    getServer().getPluginManager().registerEvents(this, this);
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent playerJoinEvent){
    ServerPlayer serverPlayer = ((CraftPlayer)playerJoinEvent.getPlayer()).getHandle();
    LivingEntity livingEntity = new Zombie(serverPlayer.level);
    livingEntity.setPos(serverPlayer.getPosition(0f));
    serverPlayer.connection.send(new ClientboundAddMobPacket(livingEntity));
  }
}
