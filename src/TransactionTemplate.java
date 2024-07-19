public abstract class TransactionTemplate {
    public final void execute() {
        selectBuilding();
        createContract();
        makePayment();
    }

    protected abstract void selectBuilding();
    protected abstract void createContract();
    protected abstract void makePayment();
    protected abstract void rollback();
}
