package nl.rickyvanrijn.projects.devstreet.gui.forms.listeners;

import nl.rickyvanrijn.projects.devstreet.gui.forms.AbstractForm;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 * Created by rri21401 on 15/05/2017.
 */
public class AbstractFormWindowFocusListener implements WindowFocusListener {
    private AbstractForm abstractForm;

    public AbstractFormWindowFocusListener(AbstractForm abstractForm){
        this.abstractForm = abstractForm;
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {

    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        abstractForm.getAbstractSettingsFrame().dispose();
    }
}
