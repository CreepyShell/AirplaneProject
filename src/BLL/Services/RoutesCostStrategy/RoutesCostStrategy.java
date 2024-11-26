package BLL.Services.RoutesCostStrategy;

import DAL.Models.Route;

public interface RoutesCostStrategy {
    Double calculateCost(Route route);
}
