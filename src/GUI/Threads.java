package GUI;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import object.Database;

public class Threads {

	ArrayList<String> csv_paths;
	ArrayList<String> folder_paths;

	public Threads() {
		csv_paths = new ArrayList<>();
		folder_paths = new ArrayList<>();
	}

	public void folow_csv(String path, Connect c) {
		csv_paths.add(path);
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (c.data) {
					changeFiles(c);

				}

			}
		}).start();

	}

	public void folow_folder(String path, Connect c) {
		folder_paths.add(path);
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (c.data) {
					changeFolder(c);

				}

			}
		}).start();

	}

	// https://github.com/ruckc/filewatcher/blob/master/src/main/java/io/ruck/filewatcher/Watcher.java
	public void changeFolder(Connect c) {
		ExecutorService servise = Executors.newCachedThreadPool();
		final FileSystem fs = FileSystems.getDefault();
		WatchService watcher=null;
		try {
			watcher = fs.newWatchService();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map<WatchKey, String> keys = new HashMap<>();
		for (int i = 0; i < this.folder_paths.size(); i++) {
			if (!keys.containsValue(folder_paths.get(i))) {
				try {
					Path path = Paths.get(folder_paths.get(i));
					// the event we want to check
					WatchKey key = path.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
					keys.put(key, folder_paths.get(i));

				} 
				catch (Exception e) {
					System.out.println("error with the folder " + folder_paths.get(i));
					
				}
			
			}
		}
		while(Thread.interrupted()==false){
			WatchKey t=null;
			try {
				 t = watcher.poll(20, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			// if there is a change then the watchkey is change
			if(t!=null){
				database(c);
				
			}
		}
	}
public void database(Connect c){
	c.data.cleardatabase();
	for (int i = 0; i < this.folder_paths.size(); i++) {
		c.enterdatabase(this.folder_paths.get(i));
		
	}
	for (int i = 0; i <this.csv_paths.size(); i++) {
		c.readCSv(this.csv_paths.get(i));
	}
}

}
