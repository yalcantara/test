package test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

public class UsingIO {

	public static void main(String[] args) throws Exception {
		Path files = Paths.get("files");

		PathMatcher m = FileSystems.getDefault().getPathMatcher("glob:**.?");

		WatchService s = FileSystems.getDefault().newWatchService();

		files.register(s, StandardWatchEventKinds.ENTRY_DELETE);

		main: for (;;) {
			WatchKey k = s.take();

			for (WatchEvent<?> e : k.pollEvents()) {
				System.out.println(e.kind());

				System.out.println(e.context().toString());

				if (e != null) {
					break main;
				}
			}
			k.reset();
		}

		System.out.println("****************************");

		try (DirectoryStream<Path> d = Files.newDirectoryStream(files, "*.txt")) {

			for (Path dp : d) {
				System.out.println(dp + " -> " + m.matches(dp));
			}
		}
		System.out.println("****************************");
		System.out.println("----------------------------");
		Files.walkFileTree(files, new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				System.out.println(dir);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println(file);
				return FileVisitResult.CONTINUE;
			}

		});
		System.out.println("----------------------------");

		Path p = Paths.get("files/sample");
		Path f = Paths.get("klk/file.txt");

		DosFileAttributes dos = f.getFileSystem().provider().readAttributes(f, DosFileAttributes.class);
		System.out.println(dos.isHidden());
		Files.getLastModifiedTime(f);
		System.out.println(p);
		System.out.println(f);
		System.out.println(p.resolve(f));
		System.out.println(p.relativize(f));
		for (Path c : p) {
			System.out.println(c);
		}
	}

}
