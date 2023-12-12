import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SalesSpikeDetector {

    public static void main(String[] args) {

        try {

            String csvFilePath = "sales_data.csv";

            List<int[]> salesData = readCSV(csvFilePath);



            Scanner scanner = new Scanner(System.in);

            int threshold = scanner.nextInt();

            int timePeriod = scanner.nextInt();



            Map<Integer, Integer> results = detectSalesSpike(salesData, threshold, timePeriod);



            if (results.isEmpty()) {

                System.out.println("No sales spike detected");

            } else {

                for (Map.Entry<Integer, Integer> entry : results.entrySet()) {

                    System.out.println("Item ID: " + entry.getKey() + ", Time Period: " + entry.getValue() + " minutes");

                }

            }

        } catch (IOException e) {

            System.out.println("Error reading CSV file: " + e.getMessage());

        }

    }
    public static List<int[]> readCSV(String csvFilePath) throws IOException {

        List<int[]> data = new ArrayList<>();



        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            reader.readLine(); // Skip header



            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int[] row = new int[parts.length - 1];

                for (int i = 0; i < row.length; i++) {

                    row[i] = Integer.parseInt(parts[i + 1]);

                }

                data.add(row);

            }

        }

        return data;

    }

//    각 분당 판매량, 임계값, 기간
//    return id, 임계값을 만족하는 최소period
    public static Map<Integer, Integer> detectSalesSpike(List<int[]> salesData, int threshold, int period) {
        Map<Integer, Integer> results = new HashMap<>();
        int itemsCount = salesData.get(0).length; //item_id 개수 10개

        for(int i=0; i<itemsCount; i++){
            Deque<Integer> dq = new LinkedList<>();
            int sum=0;
            int minPeriod = 1000000;
            for (int minute=0;minute<salesData.size();minute++){
                sum+=salesData.get(minute)[i]; //해당 시간에 해당하는 현재 item의 판매량 더하기.
                dq.offerLast(minute); //현재 시간 dq에 넣음

                while (sum>=threshold){ //임계값에 도달했다면 실행됨.
                    minPeriod=Math.min(minPeriod,dq.peekLast()-dq.peekFirst()+1);
                    sum-=salesData.get(dq.pollFirst())[i];
                }
            }
            if (minPeriod <= period) {
                results.put(i + 1, minPeriod);
            }
        }
        return results;

    }







}



