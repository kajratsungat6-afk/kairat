import java.util.ArrayList;
import java.time.Year;

public class Main {
    public static void main(String[] args) {

        ArrayList<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture("Java OOP Basics", 2024, 90, "HD"));
        items.add(new VideoLecture("Advanced Java", 2022, 120, "4K"));

        items.add(new PodcastEpisode("Tech Talk", 2023, 60, "Alice"));
        items.add(new PodcastEpisode("Dev Life", 2021, 45, "Bob"));

        int currentYear = Year.now().getValue();

        for (ContentItem item : items) {
            System.out.println(item +
                    " | licenseCost=" +
                    item.getLicenseCost(currentYear));

            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                d.download();
                System.out.println("Max downloads/day: " + d.getMaxDownloadsPerDay());
            }

            System.out.println("---------------");
        }
    }
}
