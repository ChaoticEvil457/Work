#include <iostream>
#include "warehouse.h"
#include "order_bst.cpp"
#include "orders_dll.cpp"

int main()
{

    // Add some items to the Inventory
    DS::Warehouse warehouse(124000);
    warehouse.inventoryAdd(30506405368, "Pokemon Digital Wristwatch", 19, 780);
    warehouse.inventoryAdd(688955839700, "Pokemon Pikachu Yellow 10-inch Mini Backpack", 19, 800);
    warehouse.inventoryAdd(7433129546525, "High Angle View of an Old Temple Tikal Canvas Art", 16.54, 1200);
    warehouse.inventoryAdd(8322324323, "Robert Abbey Double 18 Inch Wall Sconce", 19, 800);
    warehouse.inventoryAdd(9798629587033, "Brain Games 110 Sudoku Medium Paperback", 1.50, 100);
    warehouse.inventoryAdd(469608136663, "Data Structures and Other Objects Using C++ 4th Forth Edition Paperback", 9.50, 100);
    warehouse.inventoryAdd(846127176880, "Case-Mate Apple iPhone Xs / X Gold Karat Case", 999.50, 9);
    warehouse.inventoryAdd(4588829411, "Zebra F701 Ballpoint Pen Black Ink", 5.50, 850);
    warehouse.inventoryAdd(4588888122, "Zebra Steel JK-Refills Blue Ink", 3.50, 150);
    warehouse.inventoryAdd(854790007189, "Saltiel Goods Blinker Fluid 8 oz Bottle", 7.99, 100);

    DS::Order *order = warehouse.ordersInsert("Gaby Moreno");
    order->addItem(4588888122, 23, 3.7);
    order->addItem(7433129546525, 1, 20);
    order->addItem(469608136663, 1, 20);

    order = warehouse.ordersInsert("Tom Hanks");
    order->addItem(9798629587033, 23, 5);
    order->addItem(688955839700, 1, 25);
    order->addItem(854790007189, 15, 13.99);

    warehouse.ordersNext();

    order = warehouse.ordersInsert("Britney Klondike");
    order->addItem(4588888122, 23, 3.7);
    order->addItem(688955839700, 1, 25);

    warehouse.ordersNext();

    order = warehouse.ordersInsert("Alex Hill");
    order->addItem(8322324323, 10, 950);
    order->addItem(7433129546525, 28, 32.50);

    std::cout << warehouse << std::endl;

    warehouse.ordersReset();
    std::cout << "Shipments profit:\n\t$" << std::fixed << std::setprecision(2) << warehouse.ordersShip() << std::endl;
    std::cout << "Updated Cash on Hand:\n\t$" << std::fixed << std::setprecision(2) << warehouse.getCash() << std::endl;

    // The following are here just to ensure they will be implemented,
    // you will want to add tests that verify their functionality
    warehouse.ordersNext();
    warehouse.ordersPrevious();
    warehouse.deleteOrder();
    warehouse.ordersCompact();
    DS::Order *order2 = warehouse.ordersAppend("Maria McLee");
    if (warehouse.ordersIsCurrentValid())
    {
        // This should be true, assuming all the above code worked as intended
        DS::Order order3 = *warehouse.ordersGetCurrent(); // Uses Order Copy constructor
        order3.addItem(7433129546525, 5, 20);
        DS::Orders oCopy = warehouse.getOrders(); // Uses Orders Copy constructor
        oCopy.append("Maria McLee");
        oCopy = warehouse.getOrders(); // Uses Orders Assignment Operator
        oCopy.append("George Smith");
        std::cout << warehouse << std::endl;
    }
    std::cout << "Reached the end";
    return 0;
}
