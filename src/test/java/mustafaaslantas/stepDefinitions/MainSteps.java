package mustafaaslantas.stepDefinitions;

import com.mustafaaslantas.utils.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import mustafaaslantas.pages.MainPages;

public class MainSteps {

    private MainPages mainPages;

    public MainSteps() {
        DriverFactory driverFactory = new DriverFactory("Android");
        mainPages = new MainPages(driverFactory.getDriver());
    }
    @Given("Go Home Page")
    public void go_home_page() {
        mainPages.HomePage();
    }
    @Given("Login")
    public void login() {
        mainPages.Login();

    }
    @Given("Find and press the search button")
    public void find_and_press_the_search_button() {
        mainPages.Search();

    }
    @Given("Press Kitap Button")
    public void press_kitap_button() {
        mainPages.Kitap();

    }
    @Given("Select Edebiyat")
    public void select_edebiyat() {
        mainPages.Edebiyat();

    }
    @Given("Press on Show All Button")
    public void press_on_show_all_button() {
        mainPages.ShowAll();

    }
    @Given("Select a random book and add it to the cart")
    public void select_a_random_book_and_add_it_to_the_cart() {
        mainPages.RandomBook();

    }
    @Then("The book in the cart must match the selected book")
    public void the_book_in_the_cart_must_match_the_selected_book() {
        mainPages.CheckBooks();

    }
    @Then("Remove the item from the cart")
    public void remove_the_item_from_the_cart() {
        mainPages.Remove();

    }
    @Then("The cart must be empty")
    public void the_cart_must_be_empty() {
        mainPages.IsEmpty();

    }

    @Given("Click to search button")
    public void click_to_search_button() {
        mainPages.Search();

    }
    @Given("Search for Orhan Pamuk")
    public void search_for_orhan_pamuk() {
        mainPages.SearchFor();

    }
    @Then("The results must be relevant to Orhan Pamuk")
    public void the_results_must_be_relevant_to_orhan_pamuk() {
        mainPages.Verify();

    }
}
