package VRML2;

import VRML2.VALUES.*;

public class WorldInfo extends NamedNode {

    public WorldInfo() {
        super();
    }

    public WorldInfo(String val) {
        super(val);
    }

    public WorldInfo(boolean val) {
        super(val);
    }

    public final MFString add_info(SFString val) {
        return ((MFString) info_).add(val);
    }

    public final MFString add_info(java.lang.String val0) {
        return ((MFString) info_).add(val0);
    }

    public final WorldInfo set_info(MFString val) {
        info_ = val;
        return this;
    }

    public final WorldInfo set_info(String alias) {
        info_ = new Alias(alias);
        return this;
    }

    public final WorldInfo set_title(SFString val) {
        title_ = val;
        return this;
    }

    public final WorldInfo set_title(String alias) {
        title_ = new Alias(alias);
        return this;
    }

    @Override
    public String codeStringAux(int l) {
        StringBuilder sb = new StringBuilder("WorldInfo {\n");

        if (null != info_
                && !info_.equals(infoDefault_)) {
            sb.append(i(l + 1)).append("info ").append(info_.codeString(l + 1)).append("\n");
        }
        if (null != title_
                && !title_.equals(titleDefault_)) {
            sb.append(i(l + 1)).append("title ").append(title_.codeString(l + 1)).append("\n");
        }
        return sb.append(i(l)).append("}").toString();
    }

    protected Value info_ = new MFString();
    protected static final MFString infoDefault_ = new VRML2.VALUES.MFString();
    protected Value title_ = null;
    protected static final SFString titleDefault_ = new SFString("");
}
