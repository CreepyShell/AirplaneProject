package BLL.Services.RoutesCostStrategy;

import DAL.Models.Route;

public class RouteCostContext {
    private final RoutesCostStrategy routesCostStrategy;
    public RouteCostContext(RoutesCostStrategy strategy){
        this.routesCostStrategy = strategy;
    }

    public double executeStrategy(Route route){
        return routesCostStrategy.calculateCost(route);
    }
}
