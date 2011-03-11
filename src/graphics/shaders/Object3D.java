/**
 * Class represents a 3D object. 
 * Consists of a mesh of triangles, any textures, lighting properties, etc. 
 */

package graphics.shaders;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;

public class Object3D {
	/*************************
	 * PROPERTIES
	 ************************/
	// Context
	Context context;
	
	// Constants
	private static final int FLOAT_SIZE_BYTES = 4;
	
    // Mesh
	Mesh mesh; 						// The mesh of triangles
	int meshID;						// Mesh file (.OFF) from resources
	
	// texture
	private boolean hasTexture;
	private int[] texFiles;
	private int[] _texIDs;
	
	// lighting
	
	// etc.
	
	/***************************
	 * CONSTRUCTOR(S)
	 **************************/
	public Object3D(int meshID, boolean hasTexture, Context context) {
		this(new int[0], meshID, hasTexture, context);
	}
	
	public Object3D(int[] texFile, int meshID, boolean hasTexture, Context context) {
		this.texFiles = texFile;
		this.meshID = meshID;
		this.hasTexture = hasTexture;
		
		// the mesh
		mesh = new Mesh(meshID, context);
		
		// texture
		_texIDs = new int[texFiles.length];
		setupTexture(context);
	} 
	
	/**************************
	 * OTHER METHODS
	 *************************/
	
	/*
	 * Calls the mesh draw functions
	 */
	public void drawMesh() {
		GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 3);
		//GLES20.glDr
	}
	
	/*
	 * Sets up the texture
	 */
	public void setupTexture(Context context) {
		if (!hasTexture)
			return;
		
		// create new texture ids
		/*int[] textures = new int[1];
        GLES20.glGenTextures(1, textures, 0);

        _texID = textures[0];
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, _texID);

        // parameters
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER,
                GLES20.GL_NEAREST);
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D,
                GLES20.GL_TEXTURE_MAG_FILTER,
                GLES20.GL_LINEAR);

        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S,
                GLES20.GL_REPEAT);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T,
                GLES20.GL_REPEAT);

        InputStream is = context.getResources()
            .openRawResource(texFile);
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream(is);
        } finally {
            try {
                is.close();
            } catch(IOException e) {
                // Ignore.
            }
        }

        // create it 
        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);
        bitmap.recycle();
        Log.d("SETUP IMAGE", _texID + "");*/
	}

	
	
	
	/***************************
	 * GET/SET
	 *************************/
	public Mesh getMesh() {
		return mesh;
	}

	public void setMesh(Mesh mesh) {
		this.mesh = mesh;
	}

	public int getMeshID() {
		return meshID;
	}

	public void setMeshID(int meshID) {
		this.meshID = meshID;
	}

	public boolean hasTexture() {
		return hasTexture;
	}

	public void setHasTexture(boolean hasTexture) {
		this.hasTexture = hasTexture;
	}

	public int[] getTexFile() {
		return texFiles;
	}

	public void setTexFile(int[] texFile) {
		this.texFiles = texFile;
	}

	public int[] get_texID() {
		return _texIDs;
	}

	public void set_texID(int[] _texid) {
		_texIDs = _texid;
	}
	
}
