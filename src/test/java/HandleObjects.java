import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by ccatari on 5/25/2016.
 */
public class HandleObjects {
    private MainContainer mainContainer;

    @BeforeClass
    public void login() {
        HomePage home = new HomePage();

        LoginFrame loginFrame = home.goToLogin();
        mainContainer = loginFrame.loginAs("ekans.c.a@gmail.com", "1nf0rm4tic4");
    }

    @Test
    public void goToInboxTest() {
        InboxHome inbox = mainContainer.goToInboxMenu();
        inbox.clickAddNewTask();
        inbox.addNexTask("task 1", 4);
        Assert.assertEquals(inbox.getLastTaskAsText(), "task 1 p4", "Task is not created properly in 'Inbox'");
    }

    @Test
    public void addAQuickTaskTest() {
        String taskName = "task1";
        int priority = 2;
        String projectName = "Personal";
        // add the task with quick form
        TopBar topBar = mainContainer.goToTopBar();
        AddTaskForm addTaskForm = topBar.clickQuickAddTask();
        addTaskForm.addTask(taskName,priority,projectName);
        // validate the creation
        ProjectMenu projectMenu = mainContainer.goToProjectMenu();
        ProjectHomePage projectHome = projectMenu.goToProject(projectName);
        Assert.assertEquals(projectHome.getLastTaskCreated(),"task1 Personal p2","Quick Task form does not create properly a task");

    }
}
