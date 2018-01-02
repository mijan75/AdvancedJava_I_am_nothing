package bd.ac.seu.mijan.cucumber.stepdefs;

import bd.ac.seu.mijan.MijanApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = MijanApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
