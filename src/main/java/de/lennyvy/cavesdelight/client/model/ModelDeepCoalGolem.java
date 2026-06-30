package de.lennyvy.cavesdelight.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelDeepCoalGolem<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("cavesdelight", "model_deep_coal_golem"), "main");
	public final ModelPart upper;
	public final ModelPart middle;
	public final ModelPart under;
	public final ModelPart head;
	public final ModelPart legRR;
	public final ModelPart legRL;
	public final ModelPart legFL;
	public final ModelPart legFR;

	public ModelDeepCoalGolem(ModelPart root) {
		this.upper = root.getChild("upper");
		this.middle = root.getChild("middle");
		this.under = root.getChild("under");
		this.head = root.getChild("head");
		this.legRR = root.getChild("legRR");
		this.legRL = root.getChild("legRL");
		this.legFL = root.getChild("legFL");
		this.legFR = root.getChild("legFR");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition upper = partdefinition.addOrReplaceChild("upper", CubeListBuilder.create(), PartPose.offset(0.0F, 18.9518F, -2.2347F));
		PartDefinition upper_r1 = upper.addOrReplaceChild("upper_r1", CubeListBuilder.create().texOffs(0, 8).addBox(-3.0F, -2.0F, -1.5F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition middle = partdefinition.addOrReplaceChild("middle", CubeListBuilder.create(), PartPose.offset(0.0F, 19.4558F, 1.1641F));
		PartDefinition middle_r1 = middle.addOrReplaceChild("middle_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.5F, -2.5F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition under = partdefinition.addOrReplaceChild("under", CubeListBuilder.create(), PartPose.offset(0.0F, 19.9518F, 3.7653F));
		PartDefinition under_r1 = under.addOrReplaceChild("under_r1", CubeListBuilder.create().texOffs(0, 15).addBox(-3.0F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 21).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, -4.0F));
		PartDefinition legRR = partdefinition.addOrReplaceChild("legRR", CubeListBuilder.create().texOffs(8, 20).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 20.0F, 4.0F));
		PartDefinition legRL = partdefinition.addOrReplaceChild("legRL", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 20.5F, 4.0F));
		PartDefinition legFL = partdefinition.addOrReplaceChild("legFL", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, -2.0F));
		PartDefinition legFR = partdefinition.addOrReplaceChild("legFR", CubeListBuilder.create().texOffs(18, 11).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.0F, -2.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		upper.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		under.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		legRR.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		legRL.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		legFL.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		legFR.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
	}
}