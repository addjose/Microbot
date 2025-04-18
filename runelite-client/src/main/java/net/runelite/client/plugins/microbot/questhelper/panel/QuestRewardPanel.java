/*
 * Copyright (c) 2021, Zoinkwiz
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.microbot.questhelper.panel;

import lombok.Getter;
import lombok.Setter;
import net.runelite.client.plugins.microbot.questhelper.rewards.Reward;
import net.runelite.client.plugins.microbot.questhelper.tools.Icon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class QuestRewardPanel extends JPanel {
    private static final ImageIcon INFO_ICON = Icon.INFO_ICON.getIcon();
    @Getter
    private final Reward reward;
    @Getter
    @Setter
    private JLabel label;

    public QuestRewardPanel(Reward reward) {
        this.reward = reward;

        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0, 0, 0, 0));

        String html1 = "<html><body style='padding: 0px; margin: 0px; width: 140px'>";
        String html2 = "</body></html>";

        label = new JLabel(html1 + reward.getDisplayText() + html2);
        label.setForeground(Color.WHITE);
        label.setSize(label.getPreferredSize());
        setPreferredSize(label.getSize());
        add(label, BorderLayout.WEST);
    }

    private void addButtonToPanel(String tooltipText) {
        String html1 = "<html><body>";
        String html2 = "</body></html>";
        tooltipText = tooltipText.replaceAll("\\n", "<br>");
        JButton b = new JButton(INFO_ICON);
        b.setPreferredSize(new Dimension(10, 10));
        b.setToolTipText(html1 + tooltipText + html2);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setMargin(new Insets(0, 0, 0, 0));
        add(b);
    }
}
