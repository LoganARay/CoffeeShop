public interface BeverageFactory {
    Bevage  getSize();
    Bevage getMilk();
    Bevage getSweetener();
    BeverageFactory getShots();
}
