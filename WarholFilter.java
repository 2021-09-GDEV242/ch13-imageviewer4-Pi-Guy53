import java.awt.Color;

/**
 * Creates a greyscale based on the amount of blue in a pixel
 *
 * @author Mihail Vaporakis
 * @version 2021-11-17
 */
public class WarholFilter extends Filter
{
    private ImageViewer img;
    /**
     * Sets the display name of this filter
     * @param name The name of the filter.
     */
    public WarholFilter(String name)
    {
        super(name);
    }

    public WarholFilter(String name, ImageViewer ref)
    {
        super(name);
        img = ref;
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        img.makeSmaller();
        img.makeSmaller();
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) 
            {
                Color pixel = image.getPixel(x, y);
                
                int redScale = pixel.getRed() + 25;
                if (redScale >= 255)
                {
                    redScale = 255;
                }

                int greenScale = pixel.getGreen() + 25;
                if (greenScale >= 255)
                {
                    greenScale = 255;
                }

                int blueScale = pixel.getBlue() + 25;
                if (blueScale >= 255)
                {
                    blueScale = 255;
                }

                image.setPixel(x, y, new Color(redScale, greenScale, blueScale));
            }
        }
    }
}