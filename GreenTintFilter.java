import java.awt.Color;

/**
 * Appies a green tint to the picture
 *
 * @author Mihail Vaporakis
 * @version 2021-11-27
 */
public class GreenTintFilter extends Filter
{
    /**
     * Sets the display name of this filter
     * @param name The name of the filter.
     */
    public GreenTintFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) 
            {
                Color pixel = image.getPixel(x, y);
                int greenScale = pixel.getGreen() + 25;
                if (greenScale >= 255)
                {
                    greenScale = 255;
                }

                image.setPixel(x, y, new Color(pixel.getRed(), greenScale, pixel.getBlue()));
            }
        }
    }
}
