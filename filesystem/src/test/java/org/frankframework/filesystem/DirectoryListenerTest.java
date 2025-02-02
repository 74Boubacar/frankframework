package org.frankframework.filesystem;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;

import org.frankframework.receivers.DirectoryListener;

public class DirectoryListenerTest extends WritableFileSystemListenerTest<Path, LocalFileSystem> {

	@TempDir
	public Path folder;

	@Override
	public FileSystemListener<Path, LocalFileSystem> createFileSystemListener() {
		DirectoryListener result=new DirectoryListener();
		result.setInputFolder(folder.toAbsolutePath().toString());
		fileAndFolderPrefix=folder.toAbsolutePath()+"/";
		return result;
	}

	@BeforeEach
	@Override
	public void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected IFileSystemTestHelper getFileSystemTestHelper() {
		return new LocalFileSystemTestHelper(folder);
	}

}
