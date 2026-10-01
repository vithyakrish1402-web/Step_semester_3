package abstract_interfaces.assigment_problems;

public class BackyardToolshed {

    public static void main(String[] args) {
        CuttingTool c = new CuttingTool();
        System.out.println(c.use());

        Pruner p = new Pruner();
        System.out.println(p.use());
    }
}
