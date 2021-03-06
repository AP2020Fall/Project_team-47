package controller.product;

import controller.Controller;
import model.others.Filter;

import java.util.ArrayList;

public class AllProductsController extends Controller {
    private static AllProductsController allProductsController;
    private ArrayList<Filter> filters;
    private String sortField;
    private String sortDirection;

    private AllProductsController() {
        filters = new ArrayList<>();
        commands = new ArrayList<>();
        initializeFilterCommands();
        initializeAllProductCommands();
        initializeSortCommands();
    }

    public static AllProductsController getInstance() {
        if (allProductsController != null)
            return allProductsController;
        allProductsController = new AllProductsController();
        return allProductsController;
    }

    private void initializeSortCommands() {
        commands.add(SortCommands.getSortCommand());
        commands.add(SortCommands.getSortCommonCommand());
    }

    private void initializeAllProductCommands() {
        commands.add(AllProductsCommand.getInitializePage());
        commands.add(AllProductsCommand.getCategoryCommand());
        commands.add(AllProductsCommand.getShowProductsWithFilterAndSortCommand());
    }

    private void initializeFilterCommands() {
        commands.add(FilterCommands.getAddFilterCommand());
        commands.add(FilterCommands.getDisableFilterCommand());
        commands.add(FilterCommands.getFilterCommonCommand());
    }

    void resetFilters() {
        if (loggedUser != null) {
            loggedUser.resetProductFilters();
        } else {
            filters.clear();
        }
    }

    void resetSort() {
        setSort(null, null);
    }


    String sortField() {
        if (loggedUser != null) {
            return loggedUser.getSortField();
        } else {
            return sortField;
        }
    }

    String sortDirection() {
        if (loggedUser != null) {
            return loggedUser.getSortDirection();
        } else {
            return sortDirection;
        }
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public void setFilters(ArrayList<Filter> filters) {
        this.filters = filters;
    }

    ArrayList<Filter> filters() {
        if (loggedUser != null) {
            return loggedUser.getProductFilters();
        } else {
            return filters;
        }
    }

    void removeFilter(Filter filter) {
        if (loggedUser != null) {
            loggedUser.removeProductFilter(filter);
        } else {
            filters.remove(filter);
        }
    }

    void addFilter(Filter filter) {
        if (loggedUser != null) {
            loggedUser.addProductFilter(filter);
        } else {
            filters.add(filter);
        }
    }

    public void setSort(String field, String direction) {
        if (loggedUser != null) {
            loggedUser.setSortField(field);
            loggedUser.setSortDirection(direction);
        } else {
            sortField = field;
            sortDirection = direction;
        }
    }

}//end AllProductController class
