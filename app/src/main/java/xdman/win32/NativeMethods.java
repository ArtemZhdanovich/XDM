package xdman.win32;

import org.tinylog.Logger;
import xdman.util.XDMUtils;

import java.io.File;

public class NativeMethods {
    private static NativeMethods _me;

    private NativeMethods() {
        String dllPath = new File(XDMUtils.getJarFile().getParentFile(), "xdm_native.dll").getAbsolutePath();
        try {
            System.load(dllPath);
        } catch (Exception e) {
            Logger.error(e);
        }
    }

    public static NativeMethods getInstance() {
        if (_me == null) {
            _me = new NativeMethods();
        }
        return _me;
    }

    public final native void keepAwakePing();

    public final native void addToStartup(String key, String value);

    public final native boolean presentInStartup(String key, String value);

    public final native void removeFromStartup(String key);

    public final native String getDownloadsFolder();

    public final native String stringTest(String str);
}
