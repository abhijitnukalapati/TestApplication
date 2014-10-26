package test.com.testapplication.activity;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import test.com.testapplication.R;


public class MyActivity extends Activity implements LoaderManager.LoaderCallbacks{

    private final int LIST_LOADER_ID = 3;
    private final String LIST_DATA_URL = "http://guidebook.com/service/v2/upcomingGuides/";
    private final String ARG_URL = "com.test.ARG_URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // initialize our list loader
        Bundle asyncLoaderBundle = new Bundle();
        asyncLoaderBundle.putString(ARG_URL, LIST_DATA_URL);
        getLoaderManager().initLoader(LIST_LOADER_ID, asyncLoaderBundle, this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        if(id == LIST_LOADER_ID) {
            return new AsyncListDataLoader(this);
        } else {
            return null;
        }
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        Toast.makeText(this, "Loading Finished", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoaderReset(Loader loader) {
        // when is this called?
    }

    static class AsyncListDataLoader extends AsyncTaskLoader<String> {

        private String url;

        public AsyncListDataLoader(Context context, String url){
            super(context);
            this.url = url;
        }

        @Override
        public String loadInBackground() {
            
            return null;
        }

        @Override
        protected void onStartLoading() {
            forceLoad();
        }

        @Override
        protected void onStopLoading() {
            cancelLoad();
        }
    }
}
