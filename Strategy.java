import org.graalvm.compiler.nodes.java.ExceptionObjectNode;

interface ShareAdapter{
    public void share(String url);
}

class FacebookAdapter implements ShareAdapter{

    @Override
    public void share(String url) {
        // TODO Auto-generated method stub
        System.out.println(url + " is shared via Facebook");
    }
}

class InstagramAdapter implements ShareAdapter{

    @Override
    public void share(String url) {
        // TODO Auto-generated method stub
        System.out.println(url + " is shared via Instagram");
    }

}

class ShareAction {
    ShareAdapter adapter;

    public void setShareAdapter(ShareAdapter newAdapter){
        adapter = newAdapter;
    }

    public void share(String url) throws Exception{
        if(adapter == null){
            throw new Exception("Share adapter is not defined");
        }
        adapter.share(url);
    }
}
public class Strategy {
    
    public static void main(String[] args){
        ShareAction action = new ShareAction();
        try{
            action.share("New Link");
        }catch(Exception e){
            System.out.println(e);
        }

        action.setShareAdapter(new FacebookAdapter());
        try {
            action.share("Facebook link");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        action.setShareAdapter(new InstagramAdapter());
        try{
            action.share("Instagram link");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
