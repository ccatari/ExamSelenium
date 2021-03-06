package com.jalasoft.testing;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jalasoft.testing.pages.*;

/**
 * Created by ccatari on 5/25/2016.
 */
public class HandleObjects {
    private static final int PRIORITY_ONE = 1;
    private static final int PRIORITY_TWO = 2;
    private static final int PRIORITY_THREE = 3;
    private static final int PRIORITY_FOUR = 4;
    private MainContainer mainContainer;

    @BeforeClass
    public void login() {
        HomePage home = new HomePage();

        LoginFrame loginFrame = home.goToLogin();
        mainContainer = loginFrame.loginAs("ekans.c.a@gmail.com", "1nf0rm4tic4");
    }

    @Test
    public void goToInboxTest() {
        String taskName = "task 1";
        int priority = PRIORITY_FOUR;

        // add task in Inbox page
        InboxHome inbox = mainContainer.goToInboxMenu();
        inbox.clickAddNewTask();
        inbox.addNexTask(taskName, priority);

        // validate the addition
        Assert.assertEquals(inbox.getLastTaskAsText().toLowerCase(), (taskName + " p" + priority).toLowerCase(), "Task is not created properly in 'Inbox'");
    }

    @Test
    public void addAQuickTaskTest() {
        String taskName = "task1";
        int priority = PRIORITY_TWO;
        String projectName = "Personal";

        // add the task with quick form
        TopBar topBar = mainContainer.goToTopBar();
        AddTaskForm addTaskForm = topBar.clickQuickAddTask();
        addTaskForm.addTask(taskName, priority, projectName);

        // validate the creation
        ProjectMenu projectMenu = mainContainer.goToProjectMenu();
        ProjectHomePage projectHome = projectMenu.goToProject(projectName);
        Assert.assertEquals(projectHome.getLastTaskCreated().toLowerCase(), (taskName + " " + projectName + " p" + priority).toLowerCase(), "Quick Task form does not create properly a task");

    }
}
