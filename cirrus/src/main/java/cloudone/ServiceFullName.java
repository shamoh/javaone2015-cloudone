package cloudone;

/**
 * Represents full name of the service.
 * <p>
 *     Immutable
 * </p>
 *
 * @author Martin Mares (martin.mares at oracle.com)
 */
public class ServiceFullName {

    private final String groupId;
    private final String artifactId;
    private final String version;

    public ServiceFullName(String groupId, String artifactId, String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    public ServiceFullName(String fullName) {
        if (fullName == null) {
            groupId = null;
            artifactId = null;
            version = null;
            return;
        }
        fullName = fullName.trim();
        //GroupId
        int ind = fullName.indexOf(':');
        if (ind < 0) {
            groupId = fullName.length() == 0 ? null : fullName;
        } else if (ind == 0) {
            groupId = null;
            fullName = fullName.substring(1);
        } else {
            groupId = fullName.substring(0, ind);
            fullName = fullName.substring(ind + 1);
        }
        //ArtifactID
        ind = fullName.indexOf(':');
        if (ind < 0) {
            artifactId = fullName.length() == 0 ? null : fullName;
        } else if (ind == 0) {
            artifactId = null;
            fullName = fullName.substring(1);
        } else {
            artifactId = fullName.substring(0, ind);
            fullName = fullName.substring(ind + 1);
        }
        //Version
        ind = fullName.indexOf(':');
        if (ind < 0) {
            version = fullName.length() == 0 ? null : fullName;
        } else if (ind == 0) {
            version = null;
        } else {
            version = fullName.substring(0, ind);
        }
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getVersion() {
        return version;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (groupId != null) {
            result.append(groupId);
        }
        result.append(':');
        if (artifactId != null) {
            result.append(artifactId);
        }
        result.append(':');
        if (version != null) {
            result.append(version);
        }
        return result.toString();
    }
}
