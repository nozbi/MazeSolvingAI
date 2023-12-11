import Controller.Controller;
import Model.Model;
import View.View;

public class App 
{
	public static void main(String[] parameter) 
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				Model model = new Model();
				View view = new View();
				new Controller(model, view);
			}
		});
	}
}


