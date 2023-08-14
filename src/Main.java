import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Album arjitAlbum =new Album("Arijit Singh","Arijit's album");
        Album alanAlum =new Album("Alan Walker","Walker's Album");

        System.out.println(arjitAlbum.addToAlbum("Keseria",3.5));
        System.out.println(arjitAlbum.addToAlbum("Tum kya mile",4.2));
        System.out.println(arjitAlbum.addToAlbum("Lal Ishq",5.1));

        System.out.println(alanAlum.addToAlbum("Faded",4.7));
        System.out.println(alanAlum.addToAlbum("Alone",4.1));
        System.out.println(alanAlum.addToAlbum("Darkside",2.5));

        LinkedList<Song> myPlaylist=new LinkedList<>();
        System.out.println(arjitAlbum.addToPlaylistFromAlbum("Keseria",myPlaylist));
        System.out.println(arjitAlbum.addToPlaylistFromAlbum("Tum kya mile",myPlaylist));
        System.out.println(arjitAlbum.addToPlaylistFromAlbum("Lal Ishq",myPlaylist));

        System.out.println(alanAlum.addToPlaylistFromAlbum("Faded",myPlaylist));
        System.out.println(alanAlum.addToPlaylistFromAlbum("Alone",myPlaylist));

        play(myPlaylist);
    }

    private static void play(LinkedList<Song> myPlaylist) {
        if(myPlaylist.size()==0){
            System.out.println("Playlist is empty");
            return;
        }
        ListIterator<Song> itr = myPlaylist.listIterator();
        System.out.println("Now playing : "+itr.next());

        Scanner sc=new Scanner(System.in);
        printMenu();

        boolean wasNext=true;

        boolean quit = false;
        while(!quit){
            System.out.println("Enter your option");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(wasNext==false){
                        itr.next();
                        wasNext=true;
                    }
                    if(!itr.hasNext()){
                        System.out.println("End of playlist");
                    }
                    else{
                        System.out.println("Currently playing : "+itr.next());
                    }
                    break;
                case 3:
                    if(wasNext==true){
                        itr.previous();
                        wasNext=false;
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You are at start of playlist");
                    }
                    else{
                        System.out.println("Currently playing : "+itr.previous());
                    }
                    break;
                case 4:
                    System.out.println("Currently playing : "+itr.previous());
                    break;
                case 5:
                    if(wasNext==false){
                        itr.next();
                        wasNext=true;
                    }
                    System.out.println("Song Deleted");
                    itr.remove();
                    break;
                case 6:printSongs(myPlaylist);
                    break;
                case 7:
                    quit=true;
                    break;
                default:
                    System.out.println("Wrong choice. Please select again");
            }
        }
    }

    private static void printSongs(LinkedList<Song> myPlaylist) {
        for(Song song:myPlaylist){
            System.out.println(song);
        }
    }

    private static void printMenu() {
        System.out.println("1. Show menu again");
        System.out.println("2. Play next song");
        System.out.println("3. Play previous song");
        System.out.println("4. Play current song again");
        System.out.println("5. Delete current song from playlist");
        System.out.println("6. Print all songs in playlist");
        System.out.println("7. Quit application");
    }
}