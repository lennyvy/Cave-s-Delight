package de.lennyvy.cavesdelight.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.animation.KeyframeAnimations;
import org.joml.Vector3f;

import de.lennyvy.cavesdelight.entity.DeepCoalGolemEntity;
import de.lennyvy.cavesdelight.client.model.animations.DeepCoalGolemAnimation;
import de.lennyvy.cavesdelight.client.model.ModelDeepCoalGolem;

import com.mojang.blaze3d.vertex.PoseStack;

public class DeepCoalGolemRenderer extends MobRenderer<DeepCoalGolemEntity, ModelDeepCoalGolem<DeepCoalGolemEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("cavesdelight:textures/entities/deep_coal_golem.png");

	public DeepCoalGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelDeepCoalGolem.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public void scale(DeepCoalGolemEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.2f, 1.2f, 1.2f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(DeepCoalGolemEntity entity) {
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelDeepCoalGolem<DeepCoalGolemEntity> {
		private final ModelPart root;
		private final Vector3f animationVecCache = new Vector3f();

		private final HierarchicalModel animator = new HierarchicalModel<DeepCoalGolemEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(DeepCoalGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				if (limbSwingAmount > 0.01f) {
					KeyframeAnimations.animate(this, DeepCoalGolemAnimation.walk, (long)(ageInTicks * 50), 3f, animationVecCache);
				}
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(DeepCoalGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}