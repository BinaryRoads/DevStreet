package nl.rickyvanrijn.projects.devstreet.gui.forms.ssh;

import nl.rickyvanrijn.projects.devstreet.models.ssh.SshModel;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.parser.Parser;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rri21401 on 18/05/2017.
 */
public class SshServiceJPanel {
    private SshModel sshModel;
//    private SshService sshService;
    private JPanel serviceComponentPanel;
    private GridBagConstraints gridBagConstraints;

    private RSyntaxTextArea syntaxTextArea;

    public SshServiceJPanel(SshModel sshModel) {
        this.sshModel = sshModel;
        this.serviceComponentPanel = new JPanel(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
    }

    public JPanel getServiceComponentPanel() {
        serviceComponentPanel.removeAll();

        syntaxTextArea = new RSyntaxTextArea(20,60);
        syntaxTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL);
        syntaxTextArea.setCodeFoldingEnabled(true);
        RTextScrollPane textScrollPane = new RTextScrollPane(syntaxTextArea);

        serviceComponentPanel.add(textScrollPane);

        return serviceComponentPanel;
    }
}
