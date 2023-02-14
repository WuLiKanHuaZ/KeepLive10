package v0;

/* compiled from: StringUtil.java */
/* loaded from: classes.dex */
public class g {
    public static String a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb.toString();
    }
}
