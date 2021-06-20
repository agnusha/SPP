public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Insert max element count");
        var n = Integer.parseInt(System.console().readLine());

        int[] list = new int[n];
        for (int i = 0; i < n; i++)
            list[i] = i;

        while (true) {
            System.out.println("Insert first element of pair");
            var p = Integer.parseInt(System.console().readLine());

            System.out.println("Insert second element of pair");
            var q = Integer.parseInt(System.console().readLine());

            if (list[p] == list[q]) {
                System.out.println("Don't added a pair: " + p + "-" + q);
                continue;
            }

            for (int i = 0; i < n; i++)
                if (list[i] == list[p])
                    list[i] = list[q];

            System.out.println("Added a pair: " + p + "-" + q);
        }
    }
}
