package org.example;

import java.util.*;

public class Main {
    public static List<Album>albums=new ArrayList<>();
    public static void main(String[] args) {
        Album album1=new Album("moosa","Siddhu Paaji");
        album1.addSongtoAlbum("295",4.05);
        album1.addSongtoAlbum("Lastride",5.0);
        album1.addSongtoAlbum("So high",3.05);
        Album album2=new Album("Arijit's Songs","Arijit singh");
        album2.addSongtoAlbum("kesariya",5);
        album2.addSongtoAlbum("jeena jeena",4.05);
        album2.addSongtoAlbum("gerua",6);

        albums.add(album1);
        albums.add(album2);
        System.out.println(album1.findSong("gerva"));
        LinkedList<Song>myPlayList=new LinkedList<>();
        album1.addToPlayListFromAlbum("295",myPlayList);
        album2.addToPlayListFromAlbum(2,myPlayList);

        play(myPlayList);


    }
    public static void play(LinkedList<Song>playList)
    {
        Scanner sc=new Scanner(System.in);
        ListIterator<Song>itr=playList.listIterator();
        int size=playList.size();
        boolean isForward=false;
        System.out.println("playlist size is"+ size);
        if(size>0)
        {
            System.out.print("Currently Playing : ");
            System.out.println(itr.next());
        }
        else {
            System.out.println("playlist is empty");
            return;
        }
        System.out.println("Enter your Choice");
        printMenu();

        boolean quit=false;
        while (!quit)
        {
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    if(isForward==false){
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext())
                        System.out.println(itr.next());
                    else
                    {
                        System.out.println("You are at the End of PlayList");
                    }
                    break;
                case 2:
                    if(isForward==true)
                    {
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious())
                        System.out.println(itr.previous());
                    else
                    {
                        System.out.println("You are at the Start Of PlayList");
                    }
                    break;
                case 3:
                    if(isForward==true) {
                        if (itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isForward = false;
                        }
                    }
                    else {
                        if (itr.hasNext())
                            System.out.println(itr.next());
                        isForward = true;
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    if(size>1) {
                        itr.remove();
                        size--;
                        System.out.println("new playlist size : "+ size);
                    }
                    else{
                        System.out.println("your List is empty");
                        break;
                    }
                    //  System.out.println("new playlist size"+ size);
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit=true;
            }        break;
        }
    }
    public static void printSongs(LinkedList<Song>playlist)
    {
        for(Song song:playlist)
            System.out.println(song);
        // return;
    }
    public static void printMenu()
    {
        System.out.println("1 - play for next song");
        System.out.println("2 - play previous Song");
        System.out.println("3 - Repeat current song");
        System.out.println("4 - Show Menu Again");
        System.out.println("5 - Delete the Current Song");
        System.out.println("6 - Print all the Songs in PlayList");
        System.out.println("7 - Exit");
    }
}