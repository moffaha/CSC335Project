/** Author: Harvey Moffat
 *  30/07/23
 *  calls classes to run as an application
 */

public class Main {
    public static void main(String[] args) {
        // Create and display the main window of the application.
        Menu window = new Menu(600, 600);
        window.setVisible(true);
    }
}
