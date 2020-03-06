import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;
import java.util.List;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
public class NewDropBox
private static final String ACCESSTOKEN = "Y Y 4l9Xt3I9AAAAAAAAAAC19Z1qSjvDQ9ixTGPkY public static void main(String args[]) throws DbxException, IOException
// Create Dropbox client DbxRequestConfig config = new DbxRequestConfig("dropbox/arun",
"enUS");
DbxClientV2 client = new DbxClientV2(config, ACCESSTOKEN);
// Get current account info
FullAccount account = client.users().getCurrentAccount();
System.out.println(account.getName().getDisplayName());
// Get files and folder metadata from Dropbox root directory
ListFolderResult result = client.files().listFolder("D:
encrypt.txt");
while (true)
for (Metadata metadata : result.getEntries())
System.out.println(metadata.getPathLower());
if (!result.getHasMore())
break;
result = client.files().listFolderContinue(result.getCursor());
// Upload "test.txt" to Dropbox
try (InputStream in = new FileInputStream("D:
encrypt.txt")) FileMetadata metadata = client.files().uploadBuilder("D:
encrypt.txt") .uploadAndFinish(in);
