package com.amartaloe.mod.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class AmartaloeMenuScreen extends Screen {
    public enum Tab { CHARACTER, FACTIONS, ACHIEVEMENTS }
    private Tab currentTab = Tab.CHARACTER;

    public AmartaloeMenuScreen() {
        super(Component.translatable("gui.amartaloe.title"));
    }

    @Override
    protected void init() {
        int buttonY = this.height / 2 - 90;
        int buttonX = this.width / 2 - 140;

        // Навигационные вкладки
        this.addRenderableWidget(Button.builder(Component.literal("Герой"), b -> currentTab = Tab.CHARACTER)
                .bounds(buttonX, buttonY, 80, 20).build());

        this.addRenderableWidget(Button.builder(Component.literal("Фракции"), b -> currentTab = Tab.FACTIONS)
                .bounds(buttonX + 90, buttonY, 80, 20).build());

        this.addRenderableWidget(Button.builder(Component.literal("Летописи"), b -> currentTab = Tab.ACHIEVEMENTS)
                .bounds(buttonX + 180, buttonY, 80, 20).build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        switch (currentTab) {
            case CHARACTER -> renderCharacterTab(graphics, centerX, centerY);
            case FACTIONS -> renderFactionsTab(graphics, centerX, centerY);
            case ACHIEVEMENTS -> renderAchievementsTab(graphics, centerX, centerY);
        }
    }

    private void renderCharacterTab(GuiGraphics graphics, int x, int y) {
        graphics.drawCenteredString(this.font, "§6[ Лист персонажа Амарталоэ ]", x, y - 50, 0xFFFFFF);
        graphics.drawString(this.font, "Уровень: 1", x - 100, y - 20, 0xE0E0E0);
        graphics.drawString(this.font, "Опыт: 0 / 1000", x - 100, y - 5, 0xE0E0E0);
    }

    private void renderFactionsTab(GuiGraphics graphics, int x, int y) {
        graphics.drawCenteredString(this.font, "§a[ Мировоззрение и Доверие ]", x, y - 50, 0xFFFFFF);
        graphics.drawString(this.font, "Северные королевства: +150 (Нейтралитет)", x - 100, y - 20, 0x55FF55);
        graphics.drawString(this.font, "Орден Зари: 0 (Неизвестно)", x - 100, y - 5, 0xAAAAAA);
    }

    private void renderAchievementsTab(GuiGraphics graphics, int x, int y) {
        graphics.drawCenteredString(this.font, "§e[ Деяния и Титулы ]", x, y - 50, 0xFFFFFF);
        graphics.drawString(this.font, "Путешествие еще не начато...", x - 100, y - 20, 0x888888);
    }

    @Override
    public boolean isPauseScreen() {
        return false; // В MMO-стиле игра на паузу не ставится
    }
}
