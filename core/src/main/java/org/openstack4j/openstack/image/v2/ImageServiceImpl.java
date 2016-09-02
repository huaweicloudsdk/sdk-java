package org.openstack4j.openstack.image.v2;

import org.openstack4j.api.Apis;
import org.openstack4j.api.image.v2.ImageService;
import org.openstack4j.api.image.v2.ImagesService;
import org.openstack4j.api.image.v2.TaskService;
import org.openstack4j.openstack.networking.internal.BaseNetworkingServices;

/**
 * Implementation of Glance V2 Image Service
 * @author emjburns
 */
public class ImageServiceImpl extends BaseNetworkingServices implements ImageService {
    /**
     * {@inheritDoc}
     */
    @Override
    public ImagesService images() {
        return Apis.get(ImagesService.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskService tasks() {
        return Apis.get(TaskService.class);
    }
}
